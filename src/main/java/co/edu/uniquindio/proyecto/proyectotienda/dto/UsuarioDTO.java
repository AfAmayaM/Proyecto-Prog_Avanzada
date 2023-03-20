package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    //Objeto de transferencia de dato, patron de diseño
    private String nombre;
    private String email;
    private String password;
    private String direccion;
    private String telefono;

}
