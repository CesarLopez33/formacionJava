package bosonit.ejercicio_72.profesor.controllers;

import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.dtos.output.ProfesorOutputDTO;
import bosonit.ejercicio_72.profesor.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ActualizarProfesor {
    @Autowired
    ProfesorService ps;

    @PutMapping("/{id}")
    ProfesorOutputDTO actualizarProfesor(@RequestBody ProfesorInputDTO profesor, @PathVariable String id){
        return ps.actualizarProfesor(profesor,id);
    }
}
