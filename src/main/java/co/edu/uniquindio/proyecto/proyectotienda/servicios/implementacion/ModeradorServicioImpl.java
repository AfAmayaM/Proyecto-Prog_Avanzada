package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Moderador;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Usuario;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ModeradorServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeradorServicioImpl implements ModeradorServicio {

    private ModeradorRepo moderadorRepo;

    public ModeradorServicioImpl(ModeradorRepo moderadorRepo) {
        this.moderadorRepo = moderadorRepo;
    }

    @Override
    public ModeradorGetDTO obtenerModerador(int codigoModerador) throws Exception {

        return convertir(obtener(codigoModerador));
    }

    public Moderador obtener(int codigoModerador) throws Exception {
        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);
        if (moderador.isEmpty()) {
            throw new Exception("El código " + codigoModerador + " no está asociado a ningún usuario");
        }
        return moderador.get();
    }
    private ModeradorGetDTO convertir(Moderador moderador) {
        return new ModeradorGetDTO(
                moderador.getCodigoModerador(),
                moderador.getNombre(),
                moderador.getApellido(),
                moderador.getCuenta().getEmail(),
                moderador.getTelefono()
        );
    }


}
