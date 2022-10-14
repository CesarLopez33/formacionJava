package bosonit.ejercicio_72.student.controllers.student;

import bosonit.ejercicio_72.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class EliminarStudent {
    @Autowired
    StudentService ss;

    @DeleteMapping("/{id}")
    void eliminarStudent(@PathVariable("id") String id) {
        ss.eliminarStudent(id);
    }
}
