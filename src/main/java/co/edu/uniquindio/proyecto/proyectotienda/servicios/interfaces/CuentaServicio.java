package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Cuenta;

public interface CuentaServicio {
    Cuenta buscarCuenta(int codigoCuenta) throws Exception;
}
