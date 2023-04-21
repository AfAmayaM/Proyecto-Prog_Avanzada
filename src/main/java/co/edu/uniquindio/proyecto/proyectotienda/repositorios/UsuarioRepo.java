package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Estado;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuarioCorreo(String correo);
    @Query("select u from Usuario u where u.email = :correo and u.contrasenia = :contrasenia")
    Usuario comprobarAutenticacion(String correo, String contrasenia);
    @Query("select u.estado from Usuario u where u.codigo = :codigo")
    Estado buscarEstado(int codigo);

}
