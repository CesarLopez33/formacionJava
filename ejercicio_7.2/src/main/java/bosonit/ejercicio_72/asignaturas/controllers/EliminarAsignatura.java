package bosonit.ejercicio_72.asignaturas.controllers;

import bosonit.ejercicio_72.asignaturas.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class EliminarAsignatura {
    @Autowired
    AsignaturaService as;

    @DeleteMapping("/{id}")
    void eliminarAsignatura(@PathVariable String id){
        as.eliminarAsignatura(id);
    }
}
