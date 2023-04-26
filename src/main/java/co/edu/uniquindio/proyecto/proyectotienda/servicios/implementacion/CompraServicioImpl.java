package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.EmailDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Compra;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Cuenta;
import co.edu.uniquindio.proyecto.proyectotienda.dto.CompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.DetalleCompra;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.EmailServicio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImpl implements CompraServicio {

    private CompraRepo compraRepo;

    private CuentaServicio cuentaServicio;

    private DetalleCompraServicio detalleCompraServicio;

    private EmailServicio emailServicio;

    public CompraServicioImpl(CompraRepo compraRepo, CuentaServicio cuentaServicio, DetalleCompraServicio detalleCompraServicio, EmailServicio emailServicio) {
        this.compraRepo = compraRepo;
        this.cuentaServicio = cuentaServicio;
        this.detalleCompraServicio = detalleCompraServicio;
        this.emailServicio = emailServicio;
    }

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = new Compra();
        Cuenta cuenta = cuentaServicio.buscarCuenta(compraDTO.getCodigoUsuario());
        compra.setCuenta(cuenta);
        compra.setFechaCompra(LocalDateTime.now());
        compra.setMetodoPago(compraDTO.getMetodoPago());
        compra.setTotal(calcularPrecio(compraDTO.getDetalleCompra(), 0, 0));

        int codigoCompra = compraRepo.save(compra).getCodigo();

        for (DetalleCompraDTO dto : compraDTO.getDetalleCompra()) {
            detalleCompraServicio.crearDetalleCompra(dto, obtenerCompra(codigoCompra));

        }
        emailServicio.enviarEmail(new EmailDTO("Compra realizada.", compraDTO.toString(), cuenta.getEmail()));

        return codigoCompra;
    }

    public double calcularPrecio(List<DetalleCompraDTO> detalleCompra, int i, double total) {
        if (i == detalleCompra.size()) {
            return total;
        } else {
            total += detalleCompra.get(i).getPrecioUnidad();
            return calcularPrecio(detalleCompra, i + 1, total);
        }
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) throws Exception {
        List<Compra> compras = compraRepo.obtenerComprasUsuario(codigoUsuario);
        List<CompraGetDTO> comprasGetDTO = new ArrayList<>();
        for (Compra compra : compras) {
            comprasGetDTO.add(convertir(compra));
        }
        return comprasGetDTO;
    }

    @Override
    public Compra obtenerCompra(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);
        if (compra.isEmpty()) {
            throw new Exception("La compra con el id " + codigoCompra + "no existe");
        }
        return compra.get();
    }

    @Override
    public CompraGetDTO obtenerCompraDTO(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);
        if (compra.isEmpty()) {
            throw new Exception("La compra con el id " + codigoCompra + "no existe");
        }
        CompraGetDTO compraGetDTO = convertir(compra.get());
        return compraGetDTO;
    }

    private CompraGetDTO convertir(Compra compra) throws Exception {
        List<DetalleCompraDTO> detalleCompraDTO = new ArrayList<>();
        for (DetalleCompra detalleCompra : compra.getDetalleCompras()) {
            detalleCompraDTO.add(detalleCompraServicio.buscarDetalleCompraDTO(detalleCompra.getCodigo()));
        }
        return new CompraGetDTO(
                compra.getCodigo(),
                compra.getFechaCompra(),
                compra.getTotal(),
                compra.getCuenta().getCodigo(),
                compra.getMetodoPago(),
                detalleCompraDTO
        );
    }
}
