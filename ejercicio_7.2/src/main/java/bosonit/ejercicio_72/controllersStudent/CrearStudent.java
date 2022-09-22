package bosonit.ejercicio_72.controllersStudent;

import bosonit.ejercicio_72.services.PersonaService;
import bosonit.ejercicio_72.services.StudentService;
import bosonit.ejercicio_72.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class CrearStudent {
    @Autowired
    StudentService ss;
    @Autowired
    PersonaService ps;

    @PostMapping()
    void crearStudent(@RequestBody Student s) {
        ss.crearStudent(s);
    }
}
