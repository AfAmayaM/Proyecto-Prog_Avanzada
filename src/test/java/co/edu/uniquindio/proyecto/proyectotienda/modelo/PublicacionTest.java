package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional
public class PublicacionTest {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearPublicacionTest() throws Exception{
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
                1,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Papas",
                "Papas de limon",
                10,
                2000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.MERCADO)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        Assertions.assertNotEquals(0, codigoPublicacion);
    }

    @Test
    public void actualizarPublicacionTest() throws Exception {
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

        PublicacionGetDTO publicacionActualizada = publicacionServicio.actualizarPublicacion(codigoPublicacion, new PublicacionDTO(
                codigoUsuario,
                publicacionServicio.obtenerPublicacion(codigoPublicacion).getProducto().getCodigo(),
                30
        ));

        Assertions.assertNotEquals(0, publicacionActualizada.getDescuento());
    }

    @Test
    public void eliminarPublicacionTest() throws Exception {
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
                "Papas",
                "Papas de limon",
                10,
                2000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.MERCADO)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        int codigoBorrado = publicacionServicio.eliminarPublicacion(codigoPublicacion);

        Assertions.assertThrows(Exception.class, () -> publicacionServicio.obtenerPublicacionDTO(codigoBorrado));
    }

    @Test
    public void obtenerPublicacionTest() throws Exception {
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
                1,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Papas",
                "Papas de limon",
                10,
                2000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.MERCADO)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        PublicacionGetDTO publicacion = publicacionServicio.obtenerPublicacionDTO(codigoPublicacion);

        Assertions.assertNotEquals(0, publicacion.getCodigo());
    }

    @Test
    public void obtenerPublicacionUsuarioTest() throws Exception {
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
                3,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Base cama",
                "Base cama de roble",
                1,
                1000000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.HOGAR)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        List<PublicacionGetDTO> publicacionGetDTO = publicacionServicio.obtenerPublicacionUsuario(codigoUsuario);

        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicacionGetDTO);
    }

    @Test
    public void eliminarPublicacionVencidaTest() throws Exception {
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
                3,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Base cama",
                "Base cama de roble",
                1,
                1000000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.HOGAR)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        List<PublicacionGetDTO> publicacionesEliminadas = publicacionServicio.eliminarPublicacionVencida(LocalDateTime.now().plus(Period.ofMonths(1)));
        for (PublicacionGetDTO pgd : publicacionesEliminadas){
            Assertions.assertThrows(Exception.class, () -> publicacionServicio.obtenerPublicacionDTO(pgd.getCodigo()));
        }
    }

    @Test
    public void listarPublicacionEstadoTest() throws Exception {
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
                3,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Base cama",
                "Base cama de roble",
                1,
                1000000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.HOGAR)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);
        List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionEstado(Estado.INACTIVA);
        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
    }

    @Test
    public void listarPublicacionCategoriaTest() throws Exception {
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
                3,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Base cama",
                "Base cama de roble",
                1,
                1000000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.HOGAR)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);
        List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionCategoria(Categoria.HOGAR);
        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
    }

    @Test
    public void listarPublicacionFavoritosTest() throws Exception {
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
                1,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Base cama",
                "Base cama de roble",
                1,
                1000000,
                codigoUsuario,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.HOGAR)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);
        usuarioServicio.marcarFavorito(codigoUsuario, codigoPublicacion);

        List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionFavoritos(codigoUsuario);
        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);


    }
}
