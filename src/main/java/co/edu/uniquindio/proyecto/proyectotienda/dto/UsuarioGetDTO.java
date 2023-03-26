package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    private int codigo;

    private String nombre;

    private String email;

    private String direccion;

    private String telefono;
}
