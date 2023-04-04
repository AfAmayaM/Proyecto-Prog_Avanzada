package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Visita implements Serializable {

    @Id
    @Column
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoVisita;

    @Column(nullable = false)
    private int cantidadVisitas;

    @ManyToOne
    private Publicacion publicacion;

    @ManyToOne
    private Cuenta cuenta;



}
