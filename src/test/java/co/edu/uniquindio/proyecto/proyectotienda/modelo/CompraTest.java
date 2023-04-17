package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional
public class CompraTest {
    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PublicacionServicio publicacionServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearCompraTest() throws Exception {
        try {
            CompraDTO compraDTO = new CompraDTO(
                    1,
                    MetodoPago.EFECTIVO
            );
            DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO(
                    2,
                    1,
                    2000000
            );
            int codigoCompra = compraServicio.crearCompra(compraDTO, Arrays.asList(detalleCompraDTO));
            Assertions.assertNotEquals(0, codigoCompra);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Amy",
                "Baez",
                "amyBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "091283012"
        );

        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

        UsuarioDTO usuarioDTO2 = new UsuarioDTO(
                "Andres",
                "Amaya",
                "aamaya@gmail.com",
                "12345",
                "Calle 24 # 2",
                "947281321"
        );

        int codigoUsuario2 = usuarioServicio.crearUsuario(usuarioDTO2);

        PublicacionDTO publicacionDTO = new PublicacionDTO(
                codigoUsuario,
                0,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Play 2",
                "Play 5 sin juegos",
                1,
                3500000,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA, Categoria.ELECTRODOMESTICOS)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasTest() throws Exception {
        try {
            List<CompraGetDTO> compras = compraServicio.listarCompras(1);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, compras);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraTest() throws Exception {
        try {
            CompraGetDTO compra = compraServicio.obtenerCompra(1);
            Assertions.assertNotEquals(0, compra.getValorTotal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
