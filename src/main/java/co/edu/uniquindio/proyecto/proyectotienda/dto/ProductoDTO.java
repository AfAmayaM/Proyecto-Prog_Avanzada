package co.edu.uniquindio.proyecto.proyectotienda.dto;

import co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence.Categoria;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor

public class ProductoDTO {

    private String nombre;
    private String descripcion;
    private int unidades;
    private float precio;
    private int codigoVendedor;
    private List<String> imagenes;
    private List<Categoria> categorias;
}
