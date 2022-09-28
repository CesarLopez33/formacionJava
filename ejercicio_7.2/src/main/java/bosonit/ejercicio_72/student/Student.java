package bosonit.ejercicio_72.student;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.student.dtos.StudentInputDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
    @JsonManagedReference(value = "personaStudent")
    private Persona persona;
    @Column
    private Integer num_hours_week;
    @Column
    private String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor")
    private Profesor profesor;
    @Column
    private String branch;
    @JoinTable(
            name = "rel_student_asig",
            joinColumns = @JoinColumn(name = "fk_student", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_asig", nullable = false),
            uniqueConstraints = @UniqueConstraint(columnNames={"fk_student", "fk_asig"})
    )
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="id_asignatura")
    @JsonManagedReference
    List<Estudiante_asignatura> asignaturas;

    public Student(StudentInputDTO s) {
        this.id_student = s.getId_student();
        this.num_hours_week = s.getNum_hours_week();
        this.comments = s.getComments();
        this.branch = s.getBranch();
    }
}
