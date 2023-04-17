package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
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
    @Sql("classpath:dataset.sql")
    public void crearComentarioTest() throws Exception{
        try {
            ComentarioDTO comentarioDTO = new ComentarioDTO(
                    "Buen producto, excelente calidad :)",
                    1,
                    2
            );

            int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);
            Assertions.assertNotEquals(0, codigoComentario);
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

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "Buen producto, excelente calidad :)",
                codigoUsuario,
                codigoPublicacion
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);

        Assertions.assertNotEquals(0, codigoComentario);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosPublicacionTest() throws Exception {
        try {
            List<ComentarioGetDTO> comentarios = comentarioServicio.listarComentariosPublicacion(1);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, comentarios);
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

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "Buen producto, excelente calidad :)",
                codigoUsuario,
                codigoPublicacion
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);

        List<ComentarioGetDTO> comentarios = comentarioServicio.listarComentariosPublicacion(codigoPublicacion);

        Assertions.assertNotEquals(Collections.EMPTY_LIST, comentarios);*/
    }
}
