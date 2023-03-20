package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Moderador implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoModerador;
    @ManyToOne
    @JoinColumn(name = "codigo_cuenta", nullable = false)
    private Cuenta cuenta;



}
