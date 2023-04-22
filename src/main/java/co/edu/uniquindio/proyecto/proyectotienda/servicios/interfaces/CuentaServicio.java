package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Cuenta;

public interface CuentaServicio {
    Cuenta buscarCuenta(int codigoCuenta) throws Exception;

    Cuenta buscarCuentaEmail(String email) throws Exception;

    void existeEmail(String email) throws Exception;

    int cambiarContrasenia(String email, String nuevaContrasenia) throws Exception;
}
