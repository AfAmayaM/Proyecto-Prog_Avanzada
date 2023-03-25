package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Compra implements Serializable {
    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private int codigo;

    @ManyToOne
    private Cuenta cuenta;

    @Column(nullable = false)
    private LocalDate fechaCompra;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private int metodoPago;
}
