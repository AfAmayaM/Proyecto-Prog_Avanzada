package co.edu.uniquindio.proyecto.proyectotienda.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
