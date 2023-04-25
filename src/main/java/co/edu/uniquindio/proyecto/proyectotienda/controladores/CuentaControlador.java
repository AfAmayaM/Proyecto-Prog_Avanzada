package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import co.edu.uniquindio.proyecto.proyectotienda.dto.CuentaDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/cuenta")
public class CuentaControlador {

    private CuentaServicio cuentaServicio;

    @PutMapping("/cambiarContra")
    public ResponseEntity<MensajeDTO> cambiarContrasenia(@RequestBody @Valid CuentaDTO cuentaDTO) throws Exception {
        int cuentaMod = cuentaServicio.cambiarContrasenia(cuentaDTO.getEmail(), cuentaDTO.getContrasenia());
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, cuentaMod));
    }
}
