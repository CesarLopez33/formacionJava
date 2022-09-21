package bosonit.ejercicio_72.controllers;

import bosonit.ejercicio_72.Persona;
import bosonit.ejercicio_72.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ActualizarPersona {
    @Autowired
    PersonaService ps;

    @PutMapping("/{id}")
    Persona actualizarPersona(@PathVariable("id") Integer id, @RequestBody Persona p) {
        return ps.actualizarPersona(id,p);
    }
}
