package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {
     private String mensaje;
     private int codigoUsuario;
     private int codigoPublicacion;
}
