package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.EmailDTO;

public interface EmailServicio {

    String enviarEmail(EmailDTO emailDTO) throws Exception;
}
