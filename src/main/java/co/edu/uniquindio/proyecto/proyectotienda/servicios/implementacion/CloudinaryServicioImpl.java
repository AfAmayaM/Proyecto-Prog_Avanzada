package co.edu.uniquindio.proyecto.proyectotienda.servicios.implementacion;

import co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
@Service
public class CloudinaryServicioImpl implements CloudinaryServicio {

    private Cloudinary cloudinary;
    private Map<String, String> config;

    public CloudinaryServicioImpl(){
        config = new HashMap<>();
        config.put("cloud_name", "");


    }

    @Override
    public Map subirImagen(File file, String carpeta) throws Exception {
        return null;
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return null;
    }

    @Override
    public File convertir(MultipartFile imagen) throws Exception {
        return null;
    }
}
