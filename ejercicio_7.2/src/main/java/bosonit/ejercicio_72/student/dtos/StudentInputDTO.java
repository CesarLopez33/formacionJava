package bosonit.ejercicio_72.student.dtos;

import lombok.Data;

@Data
public class StudentInputDTO {
    private String id_student;
    private Integer id_persona;
    private Integer num_hours_week;
    private String comments;
    private String id_profesor;
    private String branch;
}
