package bosonit.ejercicio_72.profesor.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfesorInputDTO {
    private Integer id_persona;
    private String comments;
    private String branch;
}
