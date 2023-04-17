package co.edu.uniquindio.proyecto.proyectotienda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class SesionDTO {

    @NotNull
    @Email
    private  String email;

    @NotNull
    private String password;

}
