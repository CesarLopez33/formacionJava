package bosonit.ejercicio_71.controllers;

import bosonit.ejercicio_71.Persona;
import bosonit.ejercicio_71.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/persona")
public class ActualizarPersonaController {
    @Autowired
    PersonaService ps;

    @PutMapping(value="{id}")
    public void actualizarPersona(@PathVariable String id, @RequestBody Persona p){
        ps.actualizarPersona(p,id);
    }
}
