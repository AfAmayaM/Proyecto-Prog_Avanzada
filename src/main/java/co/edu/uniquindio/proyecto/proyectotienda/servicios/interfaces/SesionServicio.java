package co.edu.uniquindio.proyecto.proyectotienda.servicios.interfaces;

import co.edu.uniquindio.proyecto.proyectotienda.dto.SesionDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.TokenDTO;
import co.edu.uniquindio.proyecto.proyectotienda.dto.UserInfo;

public interface SesionServicio {

    TokenDTO login(SesionDTO sesionDTO) throws Exception;

    TokenDTO googleOneTapLogin(String idTokenString) throws Exception;

    TokenDTO googleLogin(UserInfo userInfo) throws Exception;
   // void logout(int codigoUsuario) throws Exception;
}
