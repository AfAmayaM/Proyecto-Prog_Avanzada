package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
public class Cuenta implements Serializable {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column (nullable = false, length = 50)
    private String nombre;

    @Column (nullable = false, length = 50)
    private String apellido;

    @Column(length = 10)
    private String telefono;


    @Column(nullable = false, length = 10)
    private String estado;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 30)
    private String contrasenia;

    @Column(nullable = false)
    private byte rol;

    @OneToMany(mappedBy = "cuenta")
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "cuenta")
    private List<Compra> compras;

    @OneToMany(mappedBy = "cuenta")
    private List<Comentario> comentarios;

    @ManyToMany
    @JoinTable(name = "favorito",
            joinColumns = {@JoinColumn(name = "cuenta_codigo")},
            inverseJoinColumns = {@JoinColumn(name = "publicacion_codigo")})
    private List<Publicacion> favoritos;
}
