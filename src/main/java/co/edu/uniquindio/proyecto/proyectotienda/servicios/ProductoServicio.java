package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence.Categoria;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO);
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO);
    int eliminarProducto(int codigoProducto);
    ProductoGetDTO obtenerProducto(int codigoProducto);
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);
    List<ProductoGetDTO> listarProductosPorEstado();

    List<ProductoGetDTO>  listarProductosFavoritos(int codigoUsuario);
    List<ProductoGetDTO>  listarProductosNombres(String nombre);
    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

}
