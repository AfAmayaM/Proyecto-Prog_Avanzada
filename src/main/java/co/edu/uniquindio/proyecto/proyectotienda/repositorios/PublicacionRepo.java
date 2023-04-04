package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Categoria;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Producto;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PublicacionRepo extends JpaRepository<Publicacion, Integer> {
    @Query("select p from Publicacion p where p.cuenta.codigo = :codigoCuenta")
    List<Publicacion> obtenerPublicacionUsuario(int codigoCuenta);

    @Query("select p from Publicacion p where p.fechaLimite >= :fechaLimiteCuenta")
    List<Publicacion> obtenerPublicacionVencida(LocalDateTime fechaLimiteCuenta);

    @Query("select p from Publicacion p where p.estado = :estado")
    List<Publicacion> listarPublicacionEstado(String estado);

    @Query("select p from Publicacion p join p.producto.categorias c where c = :categoria")
    List<Publicacion> listarPublicacionCategoria(Categoria categoria);

    @Query("select f from Cuenta c join c.favoritos f where c.codigo = :codigoUsuario")
    List<Publicacion> listarPublicacionFavoritos(int codigoUsuario);

}
