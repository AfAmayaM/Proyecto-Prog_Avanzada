package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.DetalleCompra;

public interface DetalleCompraServicio {
    DetalleCompra buscarDetalleCompra(int codigoDetalleCompra) throws Exception;
}
