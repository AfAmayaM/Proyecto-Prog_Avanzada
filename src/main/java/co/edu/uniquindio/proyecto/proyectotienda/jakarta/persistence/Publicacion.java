package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Publicacion implements Serializable {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne
    private Cuenta cuenta;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @Column(nullable = false)
    private int descuento;

    @Column(nullable = false, length = 1)
    private String estado;

    @OneToOne
    private Producto producto;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @ManyToMany(mappedBy = "favoritos")
    private List<Cuenta> cuentas;
}
