package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Categoria;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Estado;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Producto;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Publicacion;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.PublicacionRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionServicioImpl implements PublicacionServicio {

    private PublicacionRepo publicacionRepo;

    private CuentaServicio cuentaServicio;

    private ProductoServicio productoServicio;

    public PublicacionServicioImpl(PublicacionRepo publicacionRepo, CuentaServicio cuentaServicio, ProductoServicio productoServicio) {
        this.publicacionRepo = publicacionRepo;
        this.cuentaServicio = cuentaServicio;
        this.productoServicio = productoServicio;
    }

    @Override
    public int crearPublicacion(PublicacionDTO publicacionDTO, ProductoDTO productoDTO) throws Exception {
        publicacionDTO.setCodigoProducto(productoServicio.crearProducto(productoDTO));
        Producto producto = productoServicio.obtenerProducto(publicacionDTO.getCodigoProducto());
        Publicacion publicacion = convertir(publicacionDTO);
        publicacion.setFechaLimite(LocalDateTime.now().plusMonths(1));
        publicacion.setDescuento(0);
        publicacion.setEstado(Estado.INACTIVA);
        producto.setPublicacion(publicacion);
        return publicacionRepo.save(publicacion).getCodigo();
    }

    @Override
    public PublicacionGetDTO actualizarPublicacion(int codigoPublicacion, PublicacionDTO publicacionDTO) throws Exception {
        validarPublicacion(codigoPublicacion);
        Publicacion publicacion = convertir(publicacionDTO);
        Publicacion data = obtenerPublicacion(codigoPublicacion);
        publicacion.setComentarios(data.getComentarios());
        publicacion.setEstado(data.getEstado());
        publicacion.setFechaLimite(data.getFechaLimite());
        publicacion.setDetalleCompras(data.getDetalleCompras());
        publicacion.setFavoritos(data.getFavoritos());
        publicacion.setCodigo(codigoPublicacion);
        return convertir(publicacionRepo.save(publicacion));
    }

    @Override
    public int eliminarPublicacion(int codigoPublicacion) throws Exception {
        validarPublicacion(codigoPublicacion);
        publicacionRepo.deleteById(codigoPublicacion);
        return codigoPublicacion;
    }

    @Override
    public PublicacionGetDTO obtenerPublicacionDTO(int codigoPublicacion) throws Exception {
        Optional<Publicacion> publicacion = publicacionRepo.findById(codigoPublicacion);
        if (publicacion.isEmpty()) {
            throw new Exception("La publicación con el id " + codigoPublicacion + " no existe");
        }
        return convertir(publicacion.get());
    }

    @Override
    public Publicacion obtenerPublicacion(int codigoPublicacion) throws Exception {
        Optional<Publicacion> publicacion = publicacionRepo.findById(codigoPublicacion);
        if (publicacion.isEmpty()) {
            throw new Exception("La publicación con el id " + codigoPublicacion + " no existe");
        }
        return publicacion.get();
    }

    @Override
    public List<PublicacionGetDTO> obtenerPublicacionUsuario(int codigoCuenta) throws Exception {
        List<Publicacion> publicaciones = publicacionRepo.obtenerPublicacionUsuario(codigoCuenta);
        List<PublicacionGetDTO> publicacionesGetDTO = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            publicacionesGetDTO.add(convertir(publicacion));
        }
        return publicacionesGetDTO;
    }

    public List<PublicacionGetDTO> eliminarPublicacionVencida(LocalDateTime date) throws Exception {
        List<Publicacion> publicacionesBorrar = publicacionRepo.obtenerPublicacionVencida(date);
        List<PublicacionGetDTO> publicacionesGetDTO = new ArrayList<>();
        if (publicacionesBorrar.isEmpty()) {
            throw new Exception("No hay publicaciones vencidas.");
        }
        for (Publicacion p : publicacionesBorrar) {
            publicacionesGetDTO.add(convertir(p));
        }
        publicacionRepo.deleteAll(publicacionesBorrar);
        return publicacionesGetDTO;
    }

    @Override
    public List<PublicacionGetDTO> listarPublicacionEstado(Estado estado) throws Exception {
        List<Publicacion> publicaciones = publicacionRepo.listarPublicacionEstado(estado);
        List<PublicacionGetDTO> publicacionesGetDTO = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            publicacionesGetDTO.add(convertir(publicacion));
        }
        return publicacionesGetDTO;
    }

    @Override
    public List<PublicacionGetDTO> listarPublicacionCategoria(Categoria categoria) throws Exception {
        List<Publicacion> publicaciones = publicacionRepo.listarPublicacionCategoria(categoria);
        List<PublicacionGetDTO> publicacionesGetDTO = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            publicacionesGetDTO.add(convertir(publicacion));
        }
        return publicacionesGetDTO;
    }

    @Override
    public List<PublicacionGetDTO> listarPublicacionFavoritos(int codigoUsuario) throws Exception {
        List<Publicacion> publicaciones = publicacionRepo.listarPublicacionFavoritos(codigoUsuario);
        List<PublicacionGetDTO> publicacionesGetDTO = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            publicacionesGetDTO.add(convertir(publicacion));
        }
        return publicacionesGetDTO;
    }

    private void validarPublicacion(int codigoPublicacion) throws Exception {
        boolean existe = publicacionRepo.existsById(codigoPublicacion);
        if (!existe) {
            throw new Exception("La publicación con el id " + codigoPublicacion + " no existe");
        }
    }

    private Publicacion convertir(PublicacionDTO publicacionDTO) throws Exception {
        Publicacion publicacion = new Publicacion();
        publicacion.setCuenta(cuentaServicio.buscarCuenta(publicacionDTO.getCodigoCuenta()));
        publicacion.setProducto(productoServicio.obtenerProducto(publicacionDTO.getCodigoProducto()));
        publicacion.setDescuento(publicacionDTO.getDescuento());
        return publicacion;
    }

    private PublicacionGetDTO convertir(Publicacion publicacion) {
        return new PublicacionGetDTO(
                publicacion.getCodigo(),
                publicacion.getCuenta().getCodigo(),
                publicacion.getProducto().getCodigo(),
                publicacion.getFechaLimite(),
                publicacion.getDescuento(),
                publicacion.getEstado(),
                publicacion.getComentarios(),
                publicacion.getDetalleCompras());
    }
}

