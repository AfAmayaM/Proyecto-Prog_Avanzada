package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootTest
@Transactional
public class ComentarioTest {

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PublicacionServicio publicacionServicio;

    @Test
    public void crearComentarioTest() throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Amy",
                "Baez",
                "amyBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "091283012"
        );

        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

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

        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "Buen producto, excelente calidad :)",
                codigoUsuario,
                codigoPublicacion
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);

        Assertions.assertNotEquals(0, codigoComentario);
    }

    @Test
    public void listarComentariosPublicacionTest() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Amy",
                "Baez",
                "amyBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "091283012"
        );

        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

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

        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "Buen producto, excelente calidad :)",
                codigoUsuario,
                codigoPublicacion
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);

        List<ComentarioGetDTO> comentarios = comentarioServicio.listarComentariosPublicacion(codigoPublicacion);

        Assertions.assertNotEquals(Collections.EMPTY_LIST, comentarios);
    }
}
