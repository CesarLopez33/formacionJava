package bosonit.ejercicio_72.profesor.controllers;

import bosonit.ejercicio_72.profesor.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class EliminarProfesor {
    @Autowired
    ProfesorService ps;

    @DeleteMapping("/{id}")
    void eliminarProfesor(@PathVariable String id){
        ps.eliminarProfesor(id);
    }
}
