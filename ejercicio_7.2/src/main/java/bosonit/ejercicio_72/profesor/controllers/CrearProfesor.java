package bosonit.ejercicio_72.profesor.controllers;

import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.dtos.output.ProfesorOutputDTO;
import bosonit.ejercicio_72.profesor.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class CrearProfesor {
    @Autowired
    ProfesorService ps;

    @PostMapping
    ProfesorOutputDTO crearProfesor(@RequestBody ProfesorInputDTO profesor){
        return ps.crearProfesor(profesor);
    }
}
