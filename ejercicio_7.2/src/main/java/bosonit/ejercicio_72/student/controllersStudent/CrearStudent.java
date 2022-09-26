package bosonit.ejercicio_72.student.controllersStudent;

import bosonit.ejercicio_72.student.dtos.StudentInputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import bosonit.ejercicio_72.student.service.StudentService;
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
    void crearStudent(@RequestBody StudentInputDTO s) {
        ss.crearStudent(s);
    }
}
