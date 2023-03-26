package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.dominio.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepo extends JpaRepository<Visita, Integer> {
}
