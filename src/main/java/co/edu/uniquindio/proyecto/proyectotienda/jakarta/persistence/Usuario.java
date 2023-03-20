package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @Column
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoUsuario;

    @Column
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "codigo_cuenta", nullable = false)
    private Cuenta cuenta;

    // @Column
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private int cantidad;

}


