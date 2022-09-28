package bosonit.ejercicio_72.profesor.controllers;

import bosonit.ejercicio_72.profesor.dtos.ProfesorOutputDTO;
import bosonit.ejercicio_72.profesor.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class ObtenerProfesor {
    @Autowired
    ProfesorService ps;

    @GetMapping("/{id}")
    ResponseEntity obtenerProfesor(@PathVariable String id, @RequestParam(defaultValue = "simple") String outputType){
        if(outputType.equals("simple")) return new ResponseEntity<>(ps.obtenerProfesor(id), HttpStatus.OK);
        else if(outputType.equals("full")) return new ResponseEntity<>(ps.obtenerProfesorPersona(id),HttpStatus.OK);
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
}
