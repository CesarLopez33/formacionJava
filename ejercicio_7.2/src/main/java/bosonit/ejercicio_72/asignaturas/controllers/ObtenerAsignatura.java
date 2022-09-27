package bosonit.ejercicio_72.asignaturas.controllers;

import bosonit.ejercicio_72.asignaturas.Estudiante_asignatura;
import bosonit.ejercicio_72.asignaturas.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class ObtenerAsignatura {
    @Autowired
    AsignaturaService as;

    @GetMapping("/{id}")
    Estudiante_asignatura obtenerAsignatura(@PathVariable String id){
        return as.obtenerAsignatura(id);
    }

    @GetMapping("/student/{id}")
    ResponseEntity obtenerAsignaturasStudent(@PathVariable String id){
        return new ResponseEntity(as.obtenerAsignaturasStudent(id), HttpStatus.OK);
    }
}
