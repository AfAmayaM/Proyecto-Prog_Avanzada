package co.edu.uniquindio.proyecto.proyectotienda.controladores;

import co.edu.uniquindio.proyecto.proyectotienda.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.modelo.Producto;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ProductoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/api/producto")
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@RequestBody @Valid ProductoDTO productoDTO) throws Exception {
        productoServicio.crearProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Producto creado correctamente."));
    }

    @PutMapping("/actualizar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @RequestBody @Valid ProductoDTO productoDTO) throws Exception {
        ProductoGetDTO producto = productoServicio.actualizarProducto(codigoProducto, productoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, producto));
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminarProducto(@PathVariable int codigoProducto) throws Exception {
        productoServicio.eliminarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Producto eliminado correctamente."));
    }

    @GetMapping("/obtener/{codigoProducto}")
    public ResponseEntity<MensajeDTO> obtenerProductoDTO(@PathVariable int codigoProducto) throws Exception {
        ProductoGetDTO producto = productoServicio.obtenerProductoDTO(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, producto));
    }

    @GetMapping("/listarNombre")
    public ResponseEntity<MensajeDTO> listarProductosNombre(@RequestParam String nombre) throws Exception {
        List<ProductoGetDTO> productos = productoServicio.listarProductosNombre(nombre);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productos));
    }

    @GetMapping("/listarPrecio")
    public ResponseEntity<MensajeDTO> listarProductosPrecio(@RequestParam double precioMinimo, @RequestParam double precioMaximo) throws Exception {
        List<ProductoGetDTO> productos = productoServicio.listarProductosPrecio(precioMinimo, precioMaximo);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productos));
    }
}
