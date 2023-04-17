package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.*;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ProductoServicio;
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
public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private PublicacionServicio publicacionServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearProductoTest() throws Exception {
        try {
            ProductoDTO productoDTO = new ProductoDTO(
                    "Iphone 14",
                    "Nuevo",
                    2,
                    3000000,
                    Arrays.asList("Img1.png", "Img2.png"),
                    Arrays.asList(Categoria.TECNOLOGIA)
            );
            int codigoProducto = productoServicio.crearProducto(productoDTO);
            Assertions.assertNotEquals(0, codigoProducto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest() throws Exception {
        try {
            ProductoGetDTO producto = productoServicio.obtenerProductoDTO(1);
            producto.setNombre("Nuevo producto");
            ProductoDTO modificado = new ProductoDTO(
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getUnidades(),
                    producto.getPrecio(),
                    producto.getImagenes(),
                    producto.getCategorias()
            );
            productoServicio.actualizarProducto(producto.getCodigo(), modificado);
            ProductoGetDTO consulta = productoServicio.obtenerProductoDTO(1);
            Assertions.assertEquals("Nuevo producto", consulta.getNombre());
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
        ProductoGetDTO productoActualizado = productoServicio.actualizarProducto(publicacionServicio.obtenerPublicacion(codigoPublicacion).getProducto().getCodigo(), new ProductoDTO(
                "Play 5",
                "Play Station 5 pro max plus extra",
                1,
                2000000,
                2,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA, Categoria.ELECTRODOMESTICOS)
        ));
        Assertions.assertNotEquals(0, productoActualizado.getCodigo());*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProducto() throws Exception {
        try {
            productoServicio.eliminarProducto(1);
            Assertions.assertTrue(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*ProductoDTO productoDTO = new ProductoDTO(
                "Play 5",
                "Nuevo",
                1,
                2000000,
                Arrays.asList("Img1.png", "Img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA)

        );

        int codigoProducto = productoServicio.crearProducto(productoDTO);
        int codigoEliminado = productoServicio.eliminarProducto(codigoProducto);

        Assertions.assertThrows(Exception.class, () -> productoServicio.obtenerProducto(codigoEliminado));*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductoTest() throws Exception {
        try {
            Producto producto = productoServicio.obtenerProducto(1);
            Assertions.assertEquals(2000000, producto.getPrecio());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*ProductoDTO productoDTO = new ProductoDTO(
                "Play 5",
                "Nuevo",
                1,
                2000000,
                Arrays.asList("Img1.png", "Img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA)
        );
        int codigoProducto = productoServicio.crearProducto(productoDTO);
        ProductoGetDTO producto = productoServicio.obtenerProductoDTO(codigoProducto);
        Assertions.assertNotEquals(0, producto.getCodigo());*/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosNombreTest() throws Exception {
        try {
            List<ProductoGetDTO> productos = productoServicio.listarProductosNombre("Camara");
            Assertions.assertNotEquals(Collections.EMPTY_LIST, productos);
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
    public void listarProductosPrecioTest()throws Exception{
        try {
            List<ProductoGetDTO> productos = productoServicio.listarProductosPrecio(1000000, 5000000);
            Assertions.assertNotEquals(Collections.EMPTY_LIST, productos);
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
