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
    @Column(length = 10)
    @EqualsAndHashCode.Include
    private String cedula;


    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column
    private String telefono;

    @Column(nullable = false, length = 10)
    private String contrasenia;


    // @Column
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private int cantidad;

}


