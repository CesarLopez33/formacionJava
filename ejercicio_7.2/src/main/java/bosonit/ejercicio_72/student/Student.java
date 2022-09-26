package bosonit.ejercicio_72.student;

import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.student.dtos.StudentInputDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Student implements java.io.Serializable{
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorIds.MiGenerador")
    private String id_student;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="id_persona")
    @JsonManagedReference
    private Persona persona;
    @Column
    private Integer num_hours_week;
    @Column
    private String comments;
    @ManyToOne
    @JoinColumn(name="id_profesor")
    private Profesor profesor;
    @Column
    private String branch;

    public Student(StudentInputDTO s) {
        this.id_student = s.getId_student();
        this.num_hours_week = s.getNum_hours_week();
        this.comments = s.getComments();
        this.branch = s.getBranch();
    }
}
