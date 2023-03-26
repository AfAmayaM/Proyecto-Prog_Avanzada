package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence.Usuario;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO) throws Exception;
    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminarUsuario(int coigoUsuario) throws Exception;

    UsuarioGetDTO obtenerusuario(int codigoUsuario) throws Exception;


}
