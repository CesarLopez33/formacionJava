package bosonit.ejercicio_72.controllersStudent;

import bosonit.ejercicio_72.dtos.StudentPersonaOutputDTO;
import bosonit.ejercicio_72.entities.Persona;
import bosonit.ejercicio_72.services.PersonaService;
import bosonit.ejercicio_72.services.StudentService;
import bosonit.ejercicio_72.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class ObtenerStudent {
    @Autowired
    StudentService ss;
    @Autowired
    PersonaService ps;

    @GetMapping("/{id}")
    ResponseEntity obtenerStudent(@PathVariable("id") String id,
                                  @RequestParam(value = "outputType",defaultValue = "simple") String outputType) {
        if(outputType.equals("simple"))
            return new ResponseEntity( ss.obtenerStudent(id), HttpStatus.OK);

        StudentPersonaOutputDTO data= new StudentPersonaOutputDTO();
        Persona p = new Persona();

        Student s = ss.obtenerStudent(id);
        data.setId_student(s.getId_student());
        data.setNum_hours_week(s.getNum_hours_week());
        data.setComents(s.getComments());

        if(s.getPersona()!=null) {
            p = ps.obtenerPersona(s.getPersona().getId_persona());
            data.setId_persona(p.getId_persona());
            data.setUser(p.getUsuario());
            data.setPassword(p.getPassword());
            data.setName(p.getName());
            data.setSurname(p.getSurname());
            data.setCompany_email(p.getCompany_email());
            data.setPersonal_email(p.getPersonal_email());
            data.setCity(p.getCity());
            data.setActive(p.getActive());
            data.setCreated_date(p.getCreated_date());
            data.setImagen_url(p.getImagen_url());
            data.setTermination_date(p.getTermination_date());
        }


        return new ResponseEntity( data, HttpStatus.OK);
    }
}
