package co.edu.uniquindio.proyecto.proyectotienda.dto;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    @NotNull
    @NotBlank
    @Length(max = 50, message = "El nombre debe tener maximo 50 caracteres")
    private String nombre;
    @NotNull
    @NotBlank
    @Length(max = 100, message = "La descripcion debe tener maximo 100 caracteres")
    private String descripcion;

    @Length(min = 1)
    private int unidades;
    private double precio;
    private List<String> imagenes;
    private List<Categoria> categorias;
}
