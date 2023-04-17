package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.CompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.DetalleCompraDTO;

import java.util.List;

public interface CompraServicio {

   int crearCompra(CompraDTO compraDTO, List<DetalleCompraDTO> detalleCompraDTO) throws Exception;

   List<CompraGetDTO> listarCompras(int codigoUsuario) throws Exception;

   CompraGetDTO obtenerCompra(int codigoCompra) throws Exception;


}
