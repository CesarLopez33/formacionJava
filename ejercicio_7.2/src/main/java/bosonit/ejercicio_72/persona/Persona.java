package bosonit.ejercicio_72.persona;

import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Persona implements java.io.Serializable{
    @Id
    @GeneratedValue
    private Integer id_persona;
    @Column
    private String usuario;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String company_email;
    @Column
    private String personal_email;
    @Column
    private String city;
    @Column
    private Boolean active;
    @Column
    private Date created_date;
    @Column
    private String imagen_url;
    @Column
    private Date termination_date;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "persona")
    @JsonBackReference
    private Student student;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "persona")
    @JsonBackReference
    private Profesor profesor;
}
