package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
public class Visita implements Serializable {

    @Id
    @Column
    private int codigoVisita;

    @Column
    private int cantidadVisitas;

    @ManyToOne
    private Publicacion publicacion;

    @ManyToOne
    private Cuenta cuenta;



}
