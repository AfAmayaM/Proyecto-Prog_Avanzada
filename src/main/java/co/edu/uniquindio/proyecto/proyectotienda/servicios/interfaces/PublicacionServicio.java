package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Categoria;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Estado;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Publicacion;

import java.time.LocalDateTime;
import java.util.List;

public interface PublicacionServicio {

    int crearPublicacion(PublicacionDTO publicacionDTO, ProductoDTO productoDTO) throws Exception;
    PublicacionGetDTO actualizarPublicacion(int codigoPublicacion, PublicacionDTO publicacionDTO) throws Exception;
    int eliminarPublicacion(int codigoPublicacion) throws Exception;
    PublicacionGetDTO obtenerPublicacionDTO(int codigoPublicacion) throws Exception;
    Publicacion obtenerPublicacion(int codigoPublicacion) throws Exception;
    List<PublicacionGetDTO> obtenerPublicacionUsuario(int codigoCuenta) throws Exception;
    List<PublicacionGetDTO> eliminarPublicacionVencida(LocalDateTime fechaLimiteCuenta) throws Exception;
    List<PublicacionGetDTO> listarPublicacionEstado(Estado estado) throws Exception;
    List<PublicacionGetDTO> listarPublicacionCategoria(Categoria categoria) throws Exception;
    List<PublicacionGetDTO> listarPublicacionFavoritos(int codigoUsuario) throws Exception;
}
