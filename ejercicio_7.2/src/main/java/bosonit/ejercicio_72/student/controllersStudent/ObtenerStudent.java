package bosonit.ejercicio_72.student.controllersStudent;

import bosonit.ejercicio_72.persona.service.PersonaService;
import bosonit.ejercicio_72.student.service.StudentService;
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
        if(outputType.equals("simple")) return new ResponseEntity( ss.obtenerStudent(id), HttpStatus.OK);
        else if (outputType.equals("full")) return new ResponseEntity( ss.obtenerStudentPersona(id), HttpStatus.OK);
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
}
