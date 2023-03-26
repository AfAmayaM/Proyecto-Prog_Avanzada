package co.edu.uniquindio.proyecto.proyectotienda.dominio;

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

    @Column (nullable = false, length = 50)
    private String nombre;

    @Column (nullable = false, length = 50)
    private String apellido;

    @Column(length = 10)
    private String telefono;
    @Column
    private String direccion;

    @OneToOne
    @JoinColumn(name = "codigo_cuenta", nullable = false)
    private Cuenta cuenta;

    // @Column
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private int cantidad;

}


