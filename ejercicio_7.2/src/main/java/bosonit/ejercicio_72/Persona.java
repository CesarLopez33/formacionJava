package bosonit.ejercicio_72;

import lombok.Data;
import javax.persistence.*;

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
    private String created_date;
    @Column
    private String imagen_url;
    @Column
    private String termination_date;
}
