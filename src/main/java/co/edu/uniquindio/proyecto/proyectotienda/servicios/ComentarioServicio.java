package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

   int crearComentario(ComentarioDTO comentarioDTO);

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);
}
