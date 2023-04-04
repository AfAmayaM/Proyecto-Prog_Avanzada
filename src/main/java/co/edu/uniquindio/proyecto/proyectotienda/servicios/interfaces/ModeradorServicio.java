package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ModeradorGetDTO;

public interface ModeradorServicio {

    ModeradorGetDTO obtenerModerador(int codigoModerador) throws Exception;
}
