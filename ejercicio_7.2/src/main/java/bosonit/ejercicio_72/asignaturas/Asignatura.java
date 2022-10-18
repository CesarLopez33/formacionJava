package bosonit.ejercicio_72.asignaturas;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "asignaturas")
@NoArgsConstructor
public class Asignatura implements Serializable {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorids.MiGenerador")
    private String id_asignatura;

    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Student> student;
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor")
    @JsonBackReference
    private Profesor profesor;
    @Column
    private String asignaturaName;
    @Column
    private String comments;
    @Column
    private Date initial_date;
    @Column
    private Date finish_date;

    public Asignatura(AsignaturaInputDTO a) {
        this.asignaturaName = a.getAsignatura();
        this.comments = a.getComments();
        this.initial_date = a.getInitial_date();
        this.finish_date = a.getFinish_date();
    }
}
