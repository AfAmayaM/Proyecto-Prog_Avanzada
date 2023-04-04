package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

   int crearComentario(ComentarioDTO comentarioDTO) throws Exception;
    List<ComentarioGetDTO> listarComentarios(int codigoProducto) throws Exception;

}
