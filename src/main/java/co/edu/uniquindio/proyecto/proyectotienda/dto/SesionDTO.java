package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class SesionDTO {

    private  String email;
    private String password;
    private int tipo;

}
