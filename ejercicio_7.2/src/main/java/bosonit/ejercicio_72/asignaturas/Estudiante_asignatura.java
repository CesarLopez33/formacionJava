package bosonit.ejercicio_72.asignaturas;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "asignaturas")
@NoArgsConstructor
public class Estudiante_asignatura implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorIds.MiGenerador")
    private String id_asignatura;

    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Student> student;
    @Column
    private String asignatura;
    @Column
    private String comments;
    @Column
    private Date initial_date;
    @Column
    private Date finish_date;

    public Estudiante_asignatura(AsignaturaInputDTO a) {
        this.asignatura = a.getAsignatura();
        this.comments = a.getComments();
        this.initial_date = a.getInitial_date();
        this.finish_date = a.getFinish_date();
    }
}
