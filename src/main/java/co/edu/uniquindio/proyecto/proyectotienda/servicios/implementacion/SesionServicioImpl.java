package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.SesionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.TokenDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UserInfo;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Cuenta;
import co.edu.uniquindio.proyecto.proyectotienda.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.proyecto.proyectotienda.seguridad.servicios.JwtService;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Collections;

@Service
public class SesionServicioImpl implements SesionServicio {

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
    private String clientId;
    @Autowired
    private CuentaServicio cuentaServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public SesionServicioImpl(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public TokenDTO login(SesionDTO sesionDTO) throws Exception {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                sesionDTO.getEmail(),
                sesionDTO.getContrasenia()
        ));

        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);

        return new TokenDTO(jwtToken);
    }

    @Override
    public TokenDTO googleOneTapLogin(String idTokenString) throws Exception {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                // Specify the CLIENT_ID of the app that accesses the backend:
                .setAudience(Collections.singletonList(clientId))
                // Or, if multiple clients access the backend:
                //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                .build();

        // (Receive idTokenString by HTTPS POST)

        System.out.println(idTokenString);

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Print user identifier
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            UserInfo userInfo = new UserInfo(
                    payload.getSubject(),
                    (String) payload.get("name"),
                    (String) payload.get("given_name"),
                    (String) payload.get("family_name"),
                    (String) payload.get("picture"),
                    (String) payload.get("email"),
                    Boolean.valueOf(payload.getEmailVerified()),
                    (String) payload.get("locale")
            );

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    new UserDetailsImpl(userInfo.email(), "", AuthorityUtils.createAuthorityList("CLIENTE")),
                    null
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
            String jwtToken = "";
            try {
                Cuenta cuenta = cuentaServicio.buscarCuentaEmail(userInfo.email());
                jwtToken = jwtService.generateToken(user, cuenta.getCodigo());
            } catch (AccountNotFoundException e) {
                int codigoUsuario = usuarioServicio.crearUsuario(new UsuarioDTO(userInfo.given_name(), userInfo.family_name(), userInfo.email(), "", null, null));
                jwtToken = jwtService.generateToken(user, codigoUsuario);
            }

            return new TokenDTO(jwtToken);

        } else {
            System.out.println("Invalid ID token.");
        }
        return null;
    }

    @Override
    public TokenDTO googleLogin(UserInfo userInfo) throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                new UserDetailsImpl(userInfo.email(), "", AuthorityUtils.createAuthorityList("CLIENTE")),
                null
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = "";
        try {
            Cuenta cuenta = cuentaServicio.buscarCuentaEmail(userInfo.email());
            jwtToken = jwtService.generateToken(user, cuenta.getCodigo());
        } catch (AccountNotFoundException e) {
            int codigoUsuario = usuarioServicio.crearUsuario(new UsuarioDTO(userInfo.given_name(), userInfo.family_name(), userInfo.email(), "", null, null));
            jwtToken = jwtService.generateToken(user, codigoUsuario);
        }

        return new TokenDTO(jwtToken);
    }
}
