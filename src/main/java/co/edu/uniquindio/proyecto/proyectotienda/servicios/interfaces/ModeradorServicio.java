package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Moderador;

public interface ModeradorServicio {
    ModeradorGetDTO obtenerModeradorDTO(int codigoModerador) throws Exception;
    Moderador obtenerModerador(int codigoModerador) throws Exception;
}