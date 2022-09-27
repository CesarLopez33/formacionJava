package bosonit.ejercicio_72.persona.dtos;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import bosonit.ejercicio_72.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentAuxOutputDTO {
    private String id_student;
    private Integer num_hours_week;
    private String comments;
    private String branch;
    private List<Estudiante_asignatura> asignaturas;
    public StudentAuxOutputDTO(Student s){
        this.id_student = s.getId_student();
        this.num_hours_week = s.getNum_hours_week();
        this.comments = s.getComments();
        this.branch = s.getBranch();
        this.asignaturas=s.getAsignaturas();
    }
}
