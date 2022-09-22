package bosonit.ejercicio_72.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Estudiante_asignatura implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorIds.MiGenerador")
    private String id_asignatura;
    @ManyToMany
    @JoinColumn(name="id_student")
    private List<Student> student;
    @Column
    private String asignaura;
    @Column
    private String comments;
    @Column
    private Date initial_date;
    @Column
    private Date finish_date;
}
