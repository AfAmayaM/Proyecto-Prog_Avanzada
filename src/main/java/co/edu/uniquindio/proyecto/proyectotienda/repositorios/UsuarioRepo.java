package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.cuenta.email = :correo")
    Usuario buscarUsuarioCorreo(String correo);

    @Query("select u from Usuario u where u.cuenta.email = :correo and u.cuenta.contrasenia = :contrasenia")
    Usuario comprobarAutenticacion(String correo, String contrasenia);







}
