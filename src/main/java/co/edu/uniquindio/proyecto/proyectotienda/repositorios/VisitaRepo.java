package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepo extends JpaRepository<Visita, Integer> {
    @Query("select v.cantidadVisitas from Visita v where v.publicacion.codigo = :codigoPublicacion")
    int cantidadVisitas(int codigoPublicacion);
}
