package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.DetalleCompraServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DetalleCompraTest {

    @Autowired
    private DetalleCompraServicio detalleCompraServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearDetalleCompraTest() {
        try {
            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO(
                    1,
                    1,
                    2000000
            );
            int codigoDetalleCompra = detalleCompraServicio.crearDetalleCompra(detalleCompraDTO);
            Assertions.assertNotEquals(0, codigoDetalleCompra);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarDetalleCompraTest() {
        try {
            DetalleCompraDTO detalleCompraDTO = detalleCompraServicio.buscarDetalleCompraDTO(1);
            Assertions.assertNotEquals(0, detalleCompraDTO.getUnidades());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
