package bosonit.ejercicio_72.asignaturas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaInputDTO {
    private String id_profesor;
    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;
}
