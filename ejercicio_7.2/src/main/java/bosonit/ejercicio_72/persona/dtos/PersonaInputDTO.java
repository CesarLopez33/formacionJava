package bosonit.ejercicio_72.persona.dtos;

import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaInputDTO implements Serializable {
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    private String id_student;
    private String id_profesor;
}
