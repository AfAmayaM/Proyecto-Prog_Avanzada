package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import co.edu.uniquindio.proyecto.proyectotienda.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.PublicacionGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Categoria;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Estado;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Publicacion;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/publicacion")
public class PublicacionControlador {

    private final PublicacionServicio publicacionServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearPublicacion(@RequestBody @Valid PublicacionDTO publicacionDTO, @RequestBody @Valid ProductoDTO productoDTO) throws Exception {
        publicacionServicio.crearPublicacion(publicacionDTO, productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Publicación creada correctamente."));
    }

    @PutMapping("/actualizar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> actualizarPublicacion(@PathVariable int codigoPublicacion, @RequestBody @Valid PublicacionDTO publicacionDTO) throws Exception {
        PublicacionGetDTO producto = publicacionServicio.actualizarPublicacion(codigoPublicacion, publicacionDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, producto));
    }

    @DeleteMapping("/eliminar/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> eliminarPublicacion(@PathVariable int codigoPublicacion) throws Exception {
        publicacionServicio.eliminarPublicacion(codigoPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Publicación eliminada exitosamente."));
    }

    @GetMapping("/obtener/{codigoPublicacion}")
    public ResponseEntity<MensajeDTO> obtenerPublicacionDTO(@PathVariable int codigoPublicacion) throws Exception {
        PublicacionGetDTO publicacion = publicacionServicio.obtenerPublicacionDTO(codigoPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicacion));
    }

    @GetMapping("/listar/{codigoCuenta}")
    public ResponseEntity<MensajeDTO> obtenerPublicacionUsuario(@PathVariable int codigoCuenta) throws Exception {
        List<PublicacionGetDTO> publicaciones = publicacionServicio.obtenerPublicacionUsuario(codigoCuenta);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicaciones));
    }

    @DeleteMapping("/eliminarVencida")
    public ResponseEntity<MensajeDTO> eliminarPublicacionVencida(@RequestParam LocalDateTime fechaLimiteCuenta) throws Exception {
        List<PublicacionGetDTO> publicaciones = publicacionServicio.eliminarPublicacionVencida(fechaLimiteCuenta);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicaciones));
    }

    @GetMapping("/listarEstado")
    public ResponseEntity<MensajeDTO> listarPublicacionEstado(@RequestParam Estado estado) throws Exception {
        List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionEstado(estado);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicaciones));
    }

    @GetMapping("/listarCategoria")
    public ResponseEntity<MensajeDTO> listarPublicacionCategoria(@RequestParam Categoria categoria) throws Exception {
        List<PublicacionGetDTO> publicaciones = publicacionServicio.listarPublicacionCategoria(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicaciones));
    }

    @GetMapping("/favoritos/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarPublicacionFavoritos(int codigoUsuario) throws Exception {
        List<PublicacionGetDTO> publicaciones =publicacionServicio.listarPublicacionFavoritos(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicaciones));
    }
}
