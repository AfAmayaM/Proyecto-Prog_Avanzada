package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publicacion implements Serializable {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne
    private Cuenta cuenta;

    @Column(nullable = false)
    private LocalDateTime fechaLimite;

    @Column(nullable = false)
    private int descuento;

    @Column(nullable = false, length = 1)
    private Estado estado;

    @OneToOne
    private Producto producto;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @ManyToMany(mappedBy = "favoritos")
    private List<Usuario> favoritos;

    @OneToMany(mappedBy = "publicacion")
    private List<DetalleCompra> detalleCompras;
}
