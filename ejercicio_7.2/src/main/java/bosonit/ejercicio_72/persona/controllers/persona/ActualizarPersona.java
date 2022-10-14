package bosonit.ejercicio_72.persona.controllers.persona;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ActualizarPersona {
    @Autowired
    PersonaService ps;

    @PutMapping("/{id}")
    PersonaOutputDTO actualizarPersona(@PathVariable("id") Integer id, @RequestBody PersonaInputDTO p) {
        return ps.actualizarPersona(id,p);
    }
}
