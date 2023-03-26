package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;

public interface PublicacionServicio {

    int crearPublicacion(PublicacionDTO publicacionDTO) throws Exception;
    int actualizarPublicacion(int codigoPublicacion, PublicacionDTO publicacionDTO) throws Exception;
    int eliminarPublicacion(int codigoPublicacion) throws Exception;
    PublicacionDTO obtenerProducto(int codigoPublicacion) throws Exception;


}
