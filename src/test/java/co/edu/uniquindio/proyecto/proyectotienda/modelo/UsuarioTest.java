package co.edu.uniquindio.proyecto.proyectotienda.modelo;

import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional//Se ejecutan varias cosas en la base de datos, varias consultas, si llega a fallar rolback si falla se vuelve a dejar como estaba
public class UsuarioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void crearUsuarioTest() throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Mateo",
                "Baez",
                "mateoBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "3193687143"
        );

        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

        //Se espera que si se registra correctamente entonces el servicio no debe retornar 0
        Assertions.assertNotEquals(0, codigoUsuario);
    }

    @Test
    public void eliminarUsuarioTest() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Mateo",
                "Baez",
                "mateoBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "3193687143"
        );

        int codigoUsuario = usuarioServicio.crearUsuario(usuarioDTO);

        int codigoBorrado = usuarioServicio.eliminarUsuario(codigoUsuario);

        //Si intentamos buscar un usuario con el codigo del usuario borrado debemos obtener una excepción indicando que ya no existe
        Assertions.assertThrows(Exception.class, () -> usuarioServicio.obtenerUsuarioDTO(codigoBorrado));
    }

    @Test
    public void actualizarUsuarioTest() throws Exception{

        //Para actualizar el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Mateo",
                "Baez",
                "mateoBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "3193687143"
        );

        int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

        //El servicio de actualizar nos retorna el usuario
        UsuarioGetDTO usuarioActualizado = usuarioServicio.actualizarUsuario(codigoNuevo, new UsuarioDTO(
                "Andres",
                "Amaya",
                "andres@email.com",
                "12345",
                "107",
                "3207772437"));

        //Se comprueba que ahora el teléfono del usuario no es el que se usó cuando se creó inicialmente
        Assertions.assertNotEquals("3193687143", usuarioActualizado.getTelefono());

    }

    @Test
    public void obtenerUsuarioTest()throws Exception{

        //Para obtener el usuario primero se debe crear
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Mateo",
                "Baez",
                "mateoBaez@gmail.com",
                "12345",
                "Calle 24 # 2",
                "3193687143"
        );

        int codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

        //Se llama el servicio para obtener el usuario completo dado su código
        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuarioDTO(codigoNuevo);

        //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
        Assertions.assertEquals("Calle 24 # 2", usuarioGetDTO.getDireccion());

    }
}
