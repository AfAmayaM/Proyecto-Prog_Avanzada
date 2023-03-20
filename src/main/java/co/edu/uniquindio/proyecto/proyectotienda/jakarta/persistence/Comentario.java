package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode
@Setter
@Getter
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
    private LocalDate fechaComentario;

}
