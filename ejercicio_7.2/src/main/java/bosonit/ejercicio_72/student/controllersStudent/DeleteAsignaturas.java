package bosonit.ejercicio_72.student.controllersStudent;

import bosonit.ejercicio_72.student.dtos.IdsAsignaturasInputDTO;
import bosonit.ejercicio_72.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/remove")
public class DeleteAsignaturas {
    @Autowired
    StudentService ss;

    @DeleteMapping("/{id}")
    void deleteAsignaturas(@PathVariable String id, @RequestBody IdsAsignaturasInputDTO ids){
        ss.deleteAsignaturas(id,ids);
    }
}
