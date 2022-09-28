package bosonit.ejercicio_72.profesor;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.profesor.dtos.ProfesorInputDTO;
import bosonit.ejercicio_72.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="profesor")
public class Profesor implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorIds.MiGenerador")
    private String id_profesor;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="id_persona")
    @JsonManagedReference(value = "personaProfesor")
    private Persona persona;
    @Column
    private String comments;
    @Column
    private String branch;
    @OneToMany(mappedBy = "profesor",fetch = FetchType.LAZY)
    private List<Student> students;

    public Profesor(ProfesorInputDTO p) {
        this.comments = p.getComments();
        this.branch = p.getBranch();
    }
}
