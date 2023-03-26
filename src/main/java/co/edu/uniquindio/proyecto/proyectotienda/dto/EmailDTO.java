package co.edu.uniquindio.proyecto.proyectotienda.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class EmailDTO {
    private String asunto;
    private String cuerpo;
    private String destinatario;
}
