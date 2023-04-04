package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Usuario;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
        Usuario buscado = usuarioRepo.buscarUsuarioCorreo(usuarioDTO.getEmail());

        if (buscado != null) {
            throw new Exception("El correo " + usuarioDTO.getEmail() + " ya se encuentra en uso");
        }
        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save(usuario).getCodigoUsuario();
    }

    @Override
    public UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCodigoUsuario(codigoUsuario);
        return convertir(usuarioRepo.save(usuario));
    }

    @Override
    public int eliminarUsuario(int codigoUsuario) throws Exception {
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerusuario(int codigoUsuario) throws Exception {
        return convertir(obtener(codigoUsuario));
    }

    public Usuario obtener(int codigoUsuario) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);
        if (usuario.isEmpty()) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }
        return usuario.get();
    }

    private void validarExiste(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario);
        if (!existe) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }

    }

    private UsuarioGetDTO convertir(Usuario usuario) {
        return new UsuarioGetDTO(
                usuario.getCodigoUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCuenta().getEmail(),
                usuario.getDireccion(),
                usuario.getTelefono()
        );
    }

    private Usuario convertir(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.getCuenta().setEmail(usuarioDTO.getEmail());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.getCuenta().setContrasenia(usuarioDTO.getContrasenia());


        return usuario;
    }
}
