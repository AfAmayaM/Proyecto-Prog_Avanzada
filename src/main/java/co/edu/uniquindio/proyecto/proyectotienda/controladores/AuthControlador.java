package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import co.edu.uniquindio.proyecto.proyectotienda.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.SesionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.TokenDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UserInfo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.SesionServicio;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthControlador {


    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
    private String clientSecret;

    @Autowired
    private final SesionServicio sesionServicio;

    @Autowired
    private MessageSource ms;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@RequestBody @Valid SesionDTO sesionDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, sesionServicio.login(sesionDTO)));
    }

    @GetMapping("/getGoogleUrl")
    public ResponseEntity<Map<String, String>> auth(@RequestParam("redirect_uri") String redirectUri) {
        String url = new GoogleAuthorizationCodeRequestUrl(clientId,
                "http://localhost:4200",
                Arrays.asList(
                        "email",
                        "profile",
                        "openid")).build();

        return ResponseEntity.ok(Map.of("url", url));
    }

    @GetMapping("/googleCallback")
    public ResponseEntity<TokenDTO> callback(@RequestParam("code") String code) throws Exception {

        String token;
        try {
            //Obtener token del usuario para solicitar información de la cuenta usando el codigo entregado por Google
            token = new GoogleAuthorizationCodeTokenRequest(
                    new NetHttpTransport(), new GsonFactory(),
                    clientId,
                    clientSecret,
                    code,
                    "http://localhost:4200"
            ).execute().getAccessToken();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Obtener la información del usuario usando el token
        UserInfo userInfo = getUserInfo(token);
        if (userInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(sesionServicio.googleLogin(userInfo));
    }

    @PostMapping("/googleOneTapLogin")
    public ResponseEntity<TokenDTO> googleOneTapLogin(@RequestBody String idTokenString) throws Exception {
        TokenDTO token = sesionServicio.googleOneTapLogin(idTokenString);
        return ResponseEntity.ok(token);
    }

    private UserInfo getUserInfo(String accessToken) {
        WebClient webClient = WebClient.create("https://www.googleapis.com");
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/oauth2/v3/userinfo")
                        .queryParam("access_token", accessToken)
                        .build())
                .retrieve()
                .bodyToMono(UserInfo.class)
                .block();
    }
}
