package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Data
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class DetalleCompra implements Serializable {

    @Id
    @Column
    private int codigo;
    @ManyToOne
    @JoinColumn(name = "codigo_publicacion")
    private Publicacion publicacion;
    @ManyToOne
    @JoinColumn(name = "codigo_compra")
    private Compra compra;

    @Column
    private int unidades;
    @Column
    private double precio;
}
