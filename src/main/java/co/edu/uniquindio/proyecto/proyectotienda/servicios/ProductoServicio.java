package co.edu.uniquindio.proyecto.proyectotienda.servicios;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.jakarta.persistence.Categoria;

import java.util.List;

public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;
    int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;
    int eliminarProducto(int codigoProducto) throws Exception;
    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;
    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception;
    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) throws Exception;
    List<ProductoGetDTO> listarProductosPorEstado(int estado) throws Exception;
    List<ProductoGetDTO>  listarProductosFavoritos(int codigoUsuario) throws Exception;
    List<ProductoGetDTO>  listarProductosNombre(String nombre) throws Exception;
    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) throws Exception;

}
