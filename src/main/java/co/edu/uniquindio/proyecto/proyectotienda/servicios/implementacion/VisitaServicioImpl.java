package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.repositorios.VisitaRepo;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.PublicacionServicio;
import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.VisitaServicio;
import org.springframework.stereotype.Service;

@Service
public class VisitaServicioImpl implements VisitaServicio {

    private VisitaRepo visitaRepo;

    private PublicacionServicio publicacionServicio;

    public VisitaServicioImpl(VisitaRepo visitaRepo, PublicacionServicio publicacionServicio){
        this.visitaRepo = visitaRepo;
        this.publicacionServicio = publicacionServicio;
    }

    @Override
    public int cantidadVisitas(int codigoPublicacion) throws Exception {
        publicacionServicio.obtenerPublicacionDTO(codigoPublicacion);
        return visitaRepo.cantidadVisitas(codigoPublicacion);
    }
}
