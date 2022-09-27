package bosonit.ejercicio_72.student.controllersStudent;

import bosonit.ejercicio_72.student.dtos.IdsAsignaturasInputDTO;
import bosonit.ejercicio_72.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/add")
public class AddAsignaturas {
    @Autowired
    StudentService ss;

    @PostMapping("/{id}")
    void addAsignaturas(@PathVariable String id, @RequestBody() IdsAsignaturasInputDTO ids_asig){
        ss.addAsignaturas(id,ids_asig);
    }
}
