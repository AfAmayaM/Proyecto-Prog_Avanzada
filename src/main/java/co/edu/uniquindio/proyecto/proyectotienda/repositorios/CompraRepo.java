package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.dominio.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {
}
