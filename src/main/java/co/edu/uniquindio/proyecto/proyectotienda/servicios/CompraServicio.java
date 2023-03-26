package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.CompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.CompraGetDTO;

import java.util.List;

public interface CompraServicio {

   int crearCompra(CompraDTO compraDTO) throws Exception;

   List<CompraGetDTO> listarCompras(int codigoUsuario) throws Exception;

   CompraGetDTO obtenerCompra(int codigoCompra) throws Exception;


}
