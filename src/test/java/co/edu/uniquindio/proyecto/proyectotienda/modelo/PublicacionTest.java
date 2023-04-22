package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
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
    @Sql("classpath:dataset.sql")
    public void crearPublicacionTest() throws Exception{
        try {
            ProductoDTO productoDTO = new ProductoDTO(
                    "Papas",
                    "Papas de limon",
                    10,
                    2000,
                    Arrays.asList("img1.png", "img2.png"),
                    Arrays.asList(Categoria.MERCADO)
            );
            PublicacionDTO publicacionDTO = new PublicacionDTO(
                    1,
                    1,
                    0,
                    productoDTO
            );
            int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO);
            Assertions.assertNotEquals(0, codigoPublicacion);
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
                1,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Papas",
                "Papas de limon",
                10,
                2000,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.MERCADO)
        );

        int codigoPublicacion = publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        Assertions.assertNotEquals(0, codigoPublicacion);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPublicacionTest() throws Exception {
        try{
            Producto producto = publicacionServicio.obtenerProductoPublicacion(1);
            PublicacionGetDTO publicacion = publicacionServicio.obtenerPublicacionDTO(1);
            publicacion.setDescuento(40);
            PublicacionDTO modificado = new PublicacionDTO(
                    publicacion.getCodigoCuenta(),
                    publicacion.getCodigoProducto(),
                    publicacion.getDescuento(),
                    new ProductoDTO(
                            producto.getNombre(),
                            producto.getDescripcion(),
                            producto.getUnidadesDisponibles(),
                            producto.getPrecio(),
                            producto.getImagen(),
                            producto.getCategorias()
                    )
            );
            publicacionServicio.actualizarPublicacion(publicacion.getCodigo(), modificado);
            PublicacionGetDTO consulta = publicacionServicio.obtenerPublicacionDTO(1);
            Assertions.assertEquals(40, consulta.getDescuento());
        }catch (Exception e) {
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

        Assertions.assertNotEquals(0, publicacionActualizada.getDescuento());*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPublicacionTest() throws Exception {
        try{
            publicacionServicio.eliminarPublicacion(1);
            Assertions.assertTrue(true);
        }catch (Exception e) {
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

        Assertions.assertThrows(Exception.class, () -> publicacionServicio.obtenerPublicacionDTO(codigoBorrado));*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPublicacionTest() throws Exception {
        try {
            Publicacion publicacion = publicacionServicio.obtenerPublicacion(1);
            Assertions.assertEquals(15, publicacion.getDescuento());
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

        Assertions.assertNotEquals(0, publicacion.getCodigo());*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPublicacionUsuarioTest() throws Exception {
        try {
            List<PublicacionGetDTO> publicaciones = publicacionServicio.obtenerPublicacionUsuario(1);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
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

        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicacionGetDTO);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarPublicacionVencidaTest() throws Exception {
        try {
            List<PublicacionGetDTO> publicaciones = publicacionServicio.eliminarPublicacionVencida(LocalDateTime.now().plusMonths(5));
            Assertions.assertTrue(true);
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
        }*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionEstadoTest() throws Exception {
        try {
            List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionEstado(Estado.ACTIVA);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
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
        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionCategoriaTest() throws Exception {
        try {
            List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionCategoria(Categoria.TECNOLOGIA);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
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
        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionFavoritosTest() throws Exception {
        try {
            List<PublicacionGetDTO> favoritos = publicacionServicio.listarPublicacionFavoritos(1);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, favoritos);
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
        Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionNombreTest() throws Exception {
        try {
            List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionNombre("Camara");
            Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
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
                1,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Papas",
                "Papas de limon",
                10,
                2000,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.MERCADO)
        );

        publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        List<ProductoGetDTO> productos = productoServicio.listarProductosNombre("papas");

        Assertions.assertNotEquals(Collections.EMPTY_LIST, productos);*/
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarPublicacionPrecioTest()throws Exception{
        try {
            List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionPrecio(1000000, 5000000);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, publicaciones);
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
                1,
                0
        );

        ProductoDTO productoDTO = new ProductoDTO(
                "Papas",
                "Papas de limon",
                10,
                2000,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.MERCADO)
        );

        publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        List<ProductoGetDTO> productos = productoServicio.listarProductosPrecio(1000, 2000);

        Assertions.assertNotEquals(Collections.EMPTY_LIST, productos);*/
    }
}
