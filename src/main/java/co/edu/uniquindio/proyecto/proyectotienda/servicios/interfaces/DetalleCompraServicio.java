package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.DetalleCompra;

public interface DetalleCompraServicio {

    int crearDetalleCompra(DetalleCompraDTO detalleCompraDTO) throws Exception;
    DetalleCompra buscarDetalleCompra(int codigoDetalleCompra) throws Exception;
    DetalleCompraDTO buscarDetalleCompraDTO(int codigoDetalleCompra) throws Exception;
}
