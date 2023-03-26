package co.edu.uniquindio.proyecto.proyectotienda.repositorios;

import co.edu.uniquindio.proyecto.proyectotienda.dominio.Moderador;
import co.edu.uniquindio.proyecto.proyectotienda.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
    @Query("select m from Moderador m where m.cuenta.email = :correo")
    Usuario buscarModerador(String correo);

    @Query("select m from Moderador m where m.cuenta.email = :correo and m.cuenta.contrasenia = :contrasenia")
    Usuario comprobarAutenticacion(String correo, String contrasenia);


}
