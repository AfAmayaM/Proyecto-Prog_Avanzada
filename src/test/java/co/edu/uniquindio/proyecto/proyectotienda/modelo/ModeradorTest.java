package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ModeradorDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ModeradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ModeradorTest {

    @Autowired
    private ModeradorServicio moderadorServicio;

    @Test
    public void obtenerModeradorTest() throws Exception{
        ModeradorDTO moderadorDTO = new ModeradorDTO(
                "Andres",
                "Amaya",
                "andres@gmail.com",
                "1234567",
                "3207772437"

        );

        int codigoModerador = 1;

        ModeradorGetDTO moderador = moderadorServicio.obtenerModerador(codigoModerador);

        Assertions.assertEquals("Juan", moderador.getNombre());

    }
}
