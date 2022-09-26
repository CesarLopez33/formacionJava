package bosonit.ejercicio_72.profesor.dtos;

import lombok.Data;

@Data
public class ProfesorInputDTO {
    private String id_profesor;
    private Integer id_persona;
    private String comments;
    private String branch;
}
