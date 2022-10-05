package bosonit.ejercicio_132.persona.controllers;

import bosonit.ejercicio_132.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_132.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_132.persona.personaServices.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class ActualizarPersona {
    @Autowired
    PersonaService ps;

    @PutMapping("{id}")
    public PersonaOutputDTO actualizarPersona(@PathVariable Integer id, @RequestBody PersonaInputDTO p){
        return ps.actualizarPersona(id,p);
    }
}
