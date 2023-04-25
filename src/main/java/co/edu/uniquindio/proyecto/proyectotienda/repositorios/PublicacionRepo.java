package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PublicacionRepo extends JpaRepository<Publicacion, Integer> {
    @Query("select p from Publicacion p where p.cuenta.codigo = :codigoCuenta")
    List<Publicacion> obtenerPublicacionUsuario(int codigoCuenta);

    @Query("select p.producto from Publicacion p where p.codigo = :codigoPublicacion")
    Producto obtenerProductoPublicacion(int codigoPublicacion);

    @Query("Select p.estado from Publicacion p where p.codigo = :codigoPublicacion")
    EstadoCuenta buscarEstadoPublicacion(int codigoPublicacion);

    @Query("select p from Publicacion p where p.fechaLimite < :fechaLimiteCuenta")
    List<Publicacion> obtenerPublicacionVencida(LocalDateTime fechaLimiteCuenta);

    @Query("select p.fechaLimite from Publicacion p where p.codigo = :codigoPublicacion")
    Object[] obtenerFechaLimite(int codigoPublicacion);

    @Query("select p from Publicacion p where p.estado = :estado")
    List<Publicacion> listarPublicacionEstado(EstadoPublicacion estado);

    @Query("select p from Publicacion p where p.producto.nombre like concat('%', :nombreProducto, '%')")
    List<Publicacion> listarPublicacionNombre(String nombreProducto);

    @Query("select p from Publicacion p where p.producto.precio between :precioMinimo and :precioMaximo")
    List<Publicacion> listarPublicacionPrecio(double precioMinimo, double precioMaximo);

    @Query("select p from Publicacion p join p.producto.categorias c where c = :categoria")
    List<Publicacion> listarPublicacionCategoria(Categoria categoria);

    @Query("select f from Usuario u join u.favoritos f where u.codigo = :codigoUsuario")
    List<Publicacion> listarPublicacionFavoritos(int codigoUsuario);

    @Query("select count(v) from Usuario u join u.visitas v where v.codigo = :codigoPublicacion")
    Integer cantidadVisitas(int codigoPublicacion);

}
