package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.dto.FavoritoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Cuenta;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.CuentaRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServicioImpl implements CuentaServicio {

    private CuentaRepo cuentaRepo;

    public CuentaServicioImpl(CuentaRepo cuentaRepo){
        this.cuentaRepo = cuentaRepo;
    }

    @Override
    public Cuenta buscarCuenta(int codigoCuenta) throws Exception {
        Optional<Cuenta> cuenta = cuentaRepo.findById(codigoCuenta);
        if(cuenta.isEmpty()){
            throw new Exception("La cuenta con el id " + codigoCuenta + " no existe");
        }
        return cuenta.get();
    }
}
