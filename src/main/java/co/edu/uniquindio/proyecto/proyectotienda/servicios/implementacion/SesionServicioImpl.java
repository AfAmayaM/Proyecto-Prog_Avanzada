package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.SesionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.TokenDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.SesionServicio;
import org.springframework.stereotype.Service;

@Service
public class SesionServicioImpl implements SesionServicio {
    @Override
    public TokenDTO login(SesionDTO sesionDTO) throws Exception {
        return null;
    }

    @Override
    public void logout(int codigoUsuario) throws Exception {

    }
}
