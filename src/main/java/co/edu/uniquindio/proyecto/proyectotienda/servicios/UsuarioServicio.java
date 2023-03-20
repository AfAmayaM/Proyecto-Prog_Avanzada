package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence.Usuario;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO);
    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO);

    int eliminarUsuario(int coigoUsuario);

    UsuarioDTO obtenerusuario(int codigoUsuario);


}
