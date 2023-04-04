package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.modelo.Comentario;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.proyectotienda.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CuentaServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    private ComentarioRepo comentarioRepo;

    private CuentaServicio cuentaServicio;

    private PublicacionServicio publicacionServicio;

    public ComentarioServicioImpl(ComentarioRepo comentarioRepo, CuentaServicio cuentaServicio, PublicacionServicio publicacionServicio){
        this.comentarioRepo = comentarioRepo;
        this.cuentaServicio = cuentaServicio;
        this.publicacionServicio = publicacionServicio;
    }

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario = convertir(comentarioDTO);
        comentario.setFechaComentario(LocalDateTime.now());
        return comentarioRepo.save(comentario).getCodigo();
    }

    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) throws Exception {
        List<ComentarioGetDTO> comentarios = new ArrayList<>();
        for (Comentario comentario : comentarioRepo.buscarPublicacion(codigoProducto)) {
            comentarios.add(convertir(comentario));
        }
        return comentarios;
    }

    private Comentario convertir(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario = new Comentario();
        comentario.setComentario(comentarioDTO.getMensaje());
        comentario.setCuenta(cuentaServicio.buscarCuenta(comentarioDTO.getCodigoUsuario()));
        comentario.setPublicacion(publicacionServicio.obtenerPublicacion(comentarioDTO.getCodigoProducto()));
        return comentario;
    }

    private ComentarioGetDTO convertir(Comentario comentario){
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getFechaComentario(),
                comentario.getComentario(),
                comentario.getCuenta().getCodigo(),
                comentario.getPublicacion().getCodigo()
        );
        return comentarioGetDTO;
    }
}
