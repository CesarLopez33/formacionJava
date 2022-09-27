package bosonit.ejercicio_72.asignaturas.controllers;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class CrearAsignatura {
    @Autowired
    AsignaturaService as;

    @PostMapping
    void crearAsignatura(@RequestBody AsignaturaInputDTO a){
        as.crearAsignatura(a);
    }
}
