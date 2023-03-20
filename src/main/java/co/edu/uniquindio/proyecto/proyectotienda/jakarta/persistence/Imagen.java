package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imagen implements Serializable {
    @Id
    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false, length = 50)
    private String url;

    @ManyToOne
    private Producto producto;
}
