package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Producto;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {
        Producto producto = convertir(productoDTO);
        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {
        validarProducto(codigoProducto);
        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);
        return convertir(productoRepo.save(producto));
    }

    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {
        validarProducto(codigoProducto);
        productoRepo.deleteById(codigoProducto);
        return codigoProducto;
    }

    @Override
    public ProductoGetDTO obtenerProductoDTO(int codigoProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);
        if (producto.isEmpty()) {
            throw new Exception("El producto con el id " + codigoProducto + " no existe");
        }
        return convertir(producto.get());
    }

    @Override
    public Producto obtenerProducto(int codigoProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);
        if (producto.isEmpty()) {
            throw new Exception("El producto con el id " + codigoProducto + " no existe");
        }
        return producto.get();
    }


    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) throws Exception {
        List<Producto> productos = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> productoGetDTO = new ArrayList<>();
        for(Producto producto : productos){
            productoGetDTO.add(convertir(producto));
        }
        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(double precioMinimo, double precioMaximo) throws Exception {
        List<Producto> productos = productoRepo.listarProductosPrecio(precioMinimo, precioMaximo);
        List<ProductoGetDTO> productoGetDTO = new ArrayList<>();
        for(Producto producto : productos){
            productoGetDTO.add(convertir(producto));
        }
        return productoGetDTO;
    }

    private Producto convertir(ProductoDTO productoDTO) throws Exception {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setUnidadesDisponibles(productoDTO.getUnidades());
        producto.setImagen(productoDTO.getImagenes());
        producto.setCategorias(productoDTO.getCategorias());
        return producto;
    }

    private ProductoGetDTO convertir(Producto producto) {
        return new ProductoGetDTO(
                producto.getCodigo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidadesDisponibles(),
                producto.getPrecio(),
                producto.getImagen(),
                producto.getCategorias()
        );
    }

    private void validarProducto(int codigoProducto) throws Exception {
        boolean existe = productoRepo.existsById(codigoProducto);
        if (!existe) {
            throw new Exception("El producto con el id " + codigoProducto + " no existe");
        }

    }
}
