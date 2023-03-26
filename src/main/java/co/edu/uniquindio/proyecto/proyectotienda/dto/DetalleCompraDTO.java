package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class DetalleCompraDTO {

    private int codigoProducto;
    private int unidades;
    private float precio;
}
