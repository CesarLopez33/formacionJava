package bosonit.ejercicio_72.student.dtos;

import bosonit.ejercicio_72.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutputDTO {
    private String id_student;
    private Integer id_persona;
    private Integer num_hours_week;
    private String comments;
    private String id_profesor;
    private String branch;


    public StudentOutputDTO(Student s){
        this.id_student = s.getId_student();
        if(s.getPersona()!=null)  this.id_persona = s.getPersona().getId_persona();
        this.num_hours_week = s.getNum_hours_week();
        this.comments = s.getComments();
        if(s.getProfesor()!=null) this.id_profesor = s.getProfesor().getId_profesor();
        this.branch = s.getBranch();
    }
}
