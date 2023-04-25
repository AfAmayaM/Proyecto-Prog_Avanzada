package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Cuenta;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.CuentaRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServicioImpl implements CuentaServicio {

    private CuentaRepo cuentaRepo;

    private PasswordEncoder passwordEncoder;

    public CuentaServicioImpl(CuentaRepo cuentaRepo, PasswordEncoder passwordEncoder){
        this.cuentaRepo = cuentaRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Cuenta buscarCuenta(int codigoCuenta) throws Exception {
        Optional<Cuenta> cuenta = cuentaRepo.findById(codigoCuenta);
        if(cuenta.isEmpty()){
            throw new Exception("La cuenta con el id " + codigoCuenta + " no existe");
        }
        return cuenta.get();
    }

    @Override
    public Cuenta buscarCuentaEmail(String email) throws Exception {
        Cuenta cuenta = cuentaRepo.findByEmail(email);
        if (cuenta == null) {
            throw new Exception("No hay ninguna cuenta con el email " + email);
        }
        return cuenta;
    }

    @Override
    public void existeEmail(String email) throws Exception {
        Cuenta cuenta = cuentaRepo.findByEmail(email);
        if (cuenta != null) {
            throw new Exception("El email ya se encuentra en uso.");
        }
    }

    @Override
    public int cambiarContrasenia(String email, String nuevaContrasenia) throws Exception {
        Cuenta cuenta = buscarCuentaEmail(email);
        cuenta.setContrasenia(passwordEncoder.encode(nuevaContrasenia));
        return cuentaRepo.save(cuenta).getCodigo();
    }
}



