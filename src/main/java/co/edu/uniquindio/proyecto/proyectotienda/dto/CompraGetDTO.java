package co.edu.uniquindio.proyecto.proyectotienda.dto;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {

    private int codigo;

    private LocalDateTime fecha;

    private float valorTotal;

    private int codigoUsuario;

   // private MetodoPago metodoPago;

    private List<DetalleCompraDTO> detalleCompraDTO;
}
