package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.EstadoCuenta;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Publicacion;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuarioCorreo(String correo);
    @Query("select u from Usuario u where u.email = :correo and u.contrasenia = :contrasenia")
    Usuario comprobarAutenticacion(String correo, String contrasenia);
    @Query("select u.estado from Usuario u where u.codigo = :codigo")
    EstadoCuenta buscarEstado(int codigo);
    @Query("select f from Usuario u join u.favoritos f where u.codigo = :codigoUsuario")
    List<Publicacion> listarPublicacionFavoritos(int codigoUsuario);
}
