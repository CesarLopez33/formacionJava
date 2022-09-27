package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ActualizarPersona {
    @Autowired
    PersonaService ps;

    @PutMapping("/{id}")
    Persona actualizarPersona(@PathVariable("id") Integer id, @RequestBody PersonaInputDTO p) {
        return ps.actualizarPersona(id,p);
    }
}
