package bosonit.ejercicio_72.asignaturas.controllers;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.asignaturas.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
public class ActualizarAsignatura {
    @Autowired
    AsignaturaService as;
    @PutMapping("/{id}")
    AsignaturaOutputDTO actualizarAsignatura(@PathVariable String id, @RequestBody AsignaturaInputDTO a){
        return as.actualizaAsignatura(id,a);
    }
}
