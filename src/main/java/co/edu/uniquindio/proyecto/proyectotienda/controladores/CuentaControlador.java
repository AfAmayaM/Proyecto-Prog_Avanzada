package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/cuenta")
public class CuentaControlador {
}
