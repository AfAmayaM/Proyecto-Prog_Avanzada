package co.edu.uniquindio.proyecto.proyectotienda.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {

     @NotEmpty(message = "")
     @Length(max = 2000, message = "")
     private String mensaje;
     private int codigoUsuario;
     private int codigoPublicacion;
}
