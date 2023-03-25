package co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
public class Favorito implements Serializable {
    @Id
    @Column
    private int codigo;



}
