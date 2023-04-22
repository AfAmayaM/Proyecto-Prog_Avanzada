package co.edu.uniquindio.proyecto.proyectotienda.dto;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PublicacionGetDTO {
    private int codigo;

    private int codigoCuenta;

    private int codigoProducto;

    private LocalDateTime fechaLimite;

    @Max(100)
    @Min(0)
    private int descuento;

    private Estado estado;

    private List<Comentario> comentarios;

    private List<DetalleCompra> detalleCompras;

    private ProductoGetDTO producto;
}
