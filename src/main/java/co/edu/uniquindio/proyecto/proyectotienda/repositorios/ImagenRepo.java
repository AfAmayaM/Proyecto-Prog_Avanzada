package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.dominio.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepo extends JpaRepository<Imagen, Integer> {
}
