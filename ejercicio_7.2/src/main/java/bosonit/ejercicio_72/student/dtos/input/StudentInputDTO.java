package bosonit.ejercicio_72.student.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentInputDTO {
    private Integer id_persona;
    private Integer num_hours_week;
    private String comments;
    private String id_profesor;
    private String branch;
}
