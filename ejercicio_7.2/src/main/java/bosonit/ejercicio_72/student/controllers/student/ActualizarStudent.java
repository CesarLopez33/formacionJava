package bosonit.ejercicio_72.student.controllers.student;

import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentOutputDTO;
import bosonit.ejercicio_72.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class ActualizarStudent {
    @Autowired
    StudentService ss;

    @PutMapping("/{id}")
    StudentOutputDTO actualizarStudent(@PathVariable("id") String id, @RequestBody StudentInputDTO s) {
        return ss.actualizarStudent(id,s);
    }
}
