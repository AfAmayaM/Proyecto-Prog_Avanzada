package co.edu.uniquindio.proyecto.proyectotienda.dto;

import co.edu.uniquindio.proyecto.proyectotienda.dominio.Categoria;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class ProductoGetDTO {

    private int codigo;
    private boolean estado;
    private LocalDateTime fechaLimite;
    private String nombre;
    private String descripcion;

    private int unidades;

    private float precio;

    private int codigoVendedor;

    private List<String> imagenes;

    private List<Categoria> categorias;
}
