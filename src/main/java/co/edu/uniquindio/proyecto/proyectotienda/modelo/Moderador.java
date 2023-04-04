package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Moderador implements Serializable {

    @Id
    @Column
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoModerador;

    @Column (nullable = false, length = 50)
    private String nombre;

    @Column (nullable = false, length = 50)
    private String apellido;

    @Column(length = 10)
    private String telefono;

    @OneToOne
    @JoinColumn(name = "codigo_cuenta", nullable = false)
    private Cuenta cuenta;



}
