package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Compra;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalleCompraServicioImpl implements DetalleCompraServicio {

    private final DetalleCompraRepo detalleCompraRepo;

    private final PublicacionServicio publicacionServicio;

    public DetalleCompraServicioImpl(DetalleCompraRepo detalleCompraRepo, PublicacionServicio publicacionServicio){
        this.detalleCompraRepo = detalleCompraRepo;
        this.publicacionServicio = publicacionServicio;
    }

    @Override
    public int crearDetalleCompra(DetalleCompraDTO detalleCompraDTO, Compra compra) throws Exception {
        DetalleCompra detalleCompra = convertir(detalleCompraDTO);
        detalleCompra.setCompra(compra);
        return detalleCompraRepo.save(detalleCompra).getCodigo();
    }

    @Override
    public DetalleCompra buscarDetalleCompra(int codigoDetalleCompra) throws Exception {
        Optional<DetalleCompra> detalleCompra = detalleCompraRepo.findById(codigoDetalleCompra);
        if(detalleCompra.isEmpty()){
            throw new Exception("El detalle compra con el id " + codigoDetalleCompra + " no existe");
        }
        return detalleCompra.get();
    }

    @Override
    public DetalleCompraDTO buscarDetalleCompraDTO(int codigoDetalleCompra) throws Exception {
        Optional<DetalleCompra> detalleCompra = detalleCompraRepo.findById(codigoDetalleCompra);
        if(detalleCompra.isEmpty()){
            throw new Exception("El detalle compra con el id " + codigoDetalleCompra + " no existe");
        }
        return convertir(detalleCompra.get());
    }

    private DetalleCompra convertir(DetalleCompraDTO detalleCompraDTO) throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setUnidades(detalleCompraDTO.getUnidades());
        detalleCompra.setPrecioUnidad(detalleCompraDTO.getPrecioUnidad());
        detalleCompra.setPublicacion(publicacionServicio.obtenerPublicacion(detalleCompraDTO.getCodigoPublicacion()));
        return detalleCompra;
    }

    private DetalleCompraDTO convertir(DetalleCompra detalleCompra) {
        return new DetalleCompraDTO(
                detalleCompra.getPublicacion().getCodigo(),
                detalleCompra.getUnidades(),
                detalleCompra.getPrecioUnidad()
        );
    }
}
