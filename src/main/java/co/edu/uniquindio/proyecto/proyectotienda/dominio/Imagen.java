package co.edu.uniquindio.proyecto.proyectotienda.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Imagen implements Serializable {
    @Id
    @Column(nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false, length = 50)
    private String url;

    @ManyToOne
    private Producto producto;
}
