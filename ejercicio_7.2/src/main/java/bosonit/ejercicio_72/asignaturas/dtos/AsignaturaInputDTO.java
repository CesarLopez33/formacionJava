package bosonit.ejercicio_72.asignaturas.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class AsignaturaInputDTO {
    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;
}
