package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import co.edu.uniquindio.proyecto.proyectotienda.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.SesionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthControlador {

    private final UsuarioServicio usuarioServicio;

    private final SesionServicio sesionServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@RequestBody @Valid SesionDTO sesionDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, sesionServicio.login(sesionDTO)));
    }

    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) throws Exception {
        usuarioServicio.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Usuario creado correctamente."));
    }
}
