package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.SesionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.TokenDTO;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO);
    void logout(int codigoUsuario);
}
