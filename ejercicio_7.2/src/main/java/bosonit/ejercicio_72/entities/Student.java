package bosonit.ejercicio_72.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table
public class Student implements java.io.Serializable{
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorIds.MiGenerador")
    private String id_student;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_persona")
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
}
