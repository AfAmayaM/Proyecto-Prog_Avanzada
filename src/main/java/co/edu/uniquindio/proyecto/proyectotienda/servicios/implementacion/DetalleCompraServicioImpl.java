package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.DetalleCompraServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalleCompraServicioImpl implements DetalleCompraServicio {

    private DetalleCompraRepo detalleCompraRepo;

    public DetalleCompraServicioImpl(DetalleCompraRepo detalleCompraRepo){
        this.detalleCompraRepo = detalleCompraRepo;
    }

    @Override
    public DetalleCompra buscarDetalleCompra(int codigoDetalleCompra) throws Exception {
        Optional<DetalleCompra> detalleCompra = detalleCompraRepo.findById(codigoDetalleCompra);
        if(detalleCompra.isEmpty()){
            throw new Exception("El detalle compra con el id " + codigoDetalleCompra + " no existe");
        }
        return detalleCompra.get();
    }


}
