package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Categoria;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Producto;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    @Query("select p from Producto p where p.nombre like concat('%', :nombre, '%')")
    List<Producto> listarProductosNombre(String nombre);

    @Query("select p from Producto p where p.precio between :precioMinimo and :precioMaximo")
    List<Producto> listarProductosPrecio(double precioMinimo, double precioMaximo);
}
