package bosonit.ejercicio_72.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table
public class Profesor implements java.io.Serializable {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "bosonit.ejercicio_72.generadorIds.MiGenerador")
    private String id_profesor;
    @OneToOne
    @JoinColumn(name="id_persona")
    private Persona persona;
    @Column
    private String comments;
    @Column
    private String branch;
}
