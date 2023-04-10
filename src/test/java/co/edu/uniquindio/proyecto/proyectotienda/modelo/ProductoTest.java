package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        ProductoDTO productoDTO = new ProductoDTO(
                "Iphone 14",
                "Nuevo",
                2,
                3000000,
                2,
                Arrays.asList("Img1.png", "Img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA)
        );
        int codigoProducto = productoServicio.crearProducto(productoDTO);
        Assertions.assertNotEquals(0, codigoProducto);
    }

    @Test
    public void actualizarProductoTest() throws Exception {
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
        ProductoGetDTO productoActualizado = productoServicio.actualizarProducto(publicacionServicio.obtenerPublicacion(codigoPublicacion).getProducto().getCodigo(), new ProductoDTO(
                "Play 5",
                "Play Station 5 pro max plus extra",
                1,
                2000000,
                2,
                Arrays.asList("img1.png", "img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA, Categoria.ELECTRODOMESTICOS)
        ));
        Assertions.assertNotEquals(0, productoActualizado.getCodigo());
    }

    @Test
    public void eliminarProducto() throws Exception {
        ProductoDTO productoDTO = new ProductoDTO(
                "Play 5",
                "Nuevo",
                1,
                2000000,
                2,
                Arrays.asList("Img1.png", "Img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA)

        );

        int codigoProducto = productoServicio.crearProducto(productoDTO);
        int codigoEliminado = productoServicio.eliminarProducto(codigoProducto);

        Assertions.assertThrows(Exception.class, () -> productoServicio.obtenerProducto(codigoEliminado));

    }

    @Test
    public void obtenerProductoTest() throws Exception {
        ProductoDTO productoDTO = new ProductoDTO(
                "Play 5",
                "Nuevo",
                1,
                2000000,
                2,
                Arrays.asList("Img1.png", "Img2.png"),
                Arrays.asList(Categoria.TECNOLOGIA)
        );
        int codigoProducto = productoServicio.crearProducto(productoDTO);
        ProductoGetDTO producto = productoServicio.obtenerProductoDTO(codigoProducto);
        Assertions.assertNotEquals(0, producto.getCodigo());
    }

    @Test
    public void listarProductosNombreTest() throws Exception {
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

        publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        List<ProductoGetDTO> productos = productoServicio.listarProductosNombre("papas");

        Assertions.assertNotEquals(Collections.EMPTY_LIST, productos);

    }
    @Test
    public void listarProductosPrecioTest()throws Exception{
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

        publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);

        List<ProductoGetDTO> productos = productoServicio.listarProductosPrecio(1000, 2000);

        Assertions.assertNotEquals(Collections.EMPTY_LIST, productos);

    }


}
