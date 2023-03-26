package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.dominio.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario, Integer> {
}
