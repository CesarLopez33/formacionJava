package bosonit.ejercicio_72.controllersStudent;

import bosonit.ejercicio_72.services.StudentService;
import bosonit.ejercicio_72.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class ActualizarStudent {
    @Autowired
    StudentService ss;

    @PutMapping("/{id}")
    Student actualizarStudent(@PathVariable("id") String id, @RequestBody Student s) {
        return ss.actualizarStudent(id,s);
    }
}
