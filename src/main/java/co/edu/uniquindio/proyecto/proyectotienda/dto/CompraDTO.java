package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;
import org.hibernate.validator.constraints.CodePointLength;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraDTO {

    private int codigoUsuario;
    //private MetodoPago
    private List<DetalleCompraDTO> detalleCompraDTO;

}
