package bosonit.ejercicio_72.student.dtos.output;

import bosonit.ejercicio_72.asignaturas.Asignatura;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentAsignaturasFullOutputDTO implements Serializable {
    private String id_student;
    private Integer num_hours_week;
    private String comments;
    private String branch;
    private List<AsignaturaOutputDTO> asignaturas;
    public StudentAsignaturasFullOutputDTO(Student s){
        this.id_student = s.getId_student();
        this.num_hours_week = s.getNum_hours_week();
        this.comments = s.getComments();
        this.branch = s.getBranch();
        this.asignaturas=s.getAsignaturas().stream().map(AsignaturaOutputDTO::new).toList();
    }
}
