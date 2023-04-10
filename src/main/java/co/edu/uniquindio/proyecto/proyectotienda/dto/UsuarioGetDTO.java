package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioGetDTO {

    private String nombre;

    private String apellido;

    private String email;

    private String direccion;

    private String telefono;

}
