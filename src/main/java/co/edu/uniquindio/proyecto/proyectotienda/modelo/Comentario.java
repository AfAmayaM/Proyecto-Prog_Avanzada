package co.edu.uniquindio.proyecto.proyectotienda.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private int codigo;

    @ManyToOne
    private Cuenta cuenta;

    @ManyToOne
    private Publicacion publicacion;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime fechaComentario;

}
