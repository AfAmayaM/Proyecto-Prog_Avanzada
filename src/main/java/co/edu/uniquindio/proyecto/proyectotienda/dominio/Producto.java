package co.edu.uniquindio.proyecto.proyectotienda.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Producto implements Serializable {
    @Id
    @Column
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int unidadesDisponibles;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;

    @ManyToMany
    private List<Categoria> categorias;

    @OneToOne(mappedBy = "producto")
    private Publicacion publicacion;
}

