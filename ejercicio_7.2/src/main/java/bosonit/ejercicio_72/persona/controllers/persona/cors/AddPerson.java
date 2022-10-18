package bosonit.ejercicio_72.persona.controllers.persona.cors;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddPerson {
    @Autowired
    PersonaService personaService;

    @CrossOrigin
    @PostMapping("/addperson")
    public PersonaOutputDTO addPerson(@RequestBody PersonaInputDTO persona){
        return personaService.crearPersona(persona);
    }
}
