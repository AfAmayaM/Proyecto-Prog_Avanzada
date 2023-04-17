package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import co.edu.uniquindio.proyecto.proyectotienda.dto.FavoritoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Usuario;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @PostMapping
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        return usuarioServicio.crearUsuario(usuarioDTO);

    }

    @PutMapping
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {
        return usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO);

    }

    @DeleteMapping
    public int eliminarUsuario(int coigoUsuario) throws Exception {
        return usuarioServicio.eliminarUsuario(coigoUsuario);

    }

    @PostMapping
    public FavoritoDTO marcarFavorito(int codigoCuenta, int codigoPublicacion) throws Exception {
        return usuarioServicio.marcarFavorito(codigoCuenta, codigoPublicacion);

    }

    @GetMapping
    public UsuarioGetDTO obtenerUsuarioDTO(int codigoUsuario) throws Exception {
        return usuarioServicio.obtenerUsuarioDTO(codigoUsuario);

    }
}
