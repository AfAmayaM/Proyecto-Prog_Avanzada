package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO {
     private String mensaje;
     private int codigoUsuario;
     private int codigoProducto;


}
