package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.VisitaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class VisitaTest {

    @Autowired
    private VisitaServicio visitaServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void cantidadVisitasTest() {
        try {
            Long cantidadVisitas = visitaServicio.cantidadVisitas(2);
            Assertions.assertNotEquals(0, cantidadVisitas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
