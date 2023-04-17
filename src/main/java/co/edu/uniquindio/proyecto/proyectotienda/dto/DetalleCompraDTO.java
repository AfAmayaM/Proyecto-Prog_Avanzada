package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraDTO {
    private int codigoPublicacion;
    private int unidades;
    private double precioUnidad;
}
