package bosonit.ejercicio_72.controllersPersona;

import bosonit.ejercicio_72.entities.Persona;
import bosonit.ejercicio_72.services.PersonaService;
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
