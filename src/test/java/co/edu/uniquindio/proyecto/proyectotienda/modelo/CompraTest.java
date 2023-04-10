package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

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
    public void crearCompraTest() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
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
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA, Categoria.ELECTRODOMESTICOS)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);
    }

    @Test
    public void listarComprasTest() throws Exception {

    }

    @Test
    public void obtenerCompraTest() throws Exception {

    }
}
