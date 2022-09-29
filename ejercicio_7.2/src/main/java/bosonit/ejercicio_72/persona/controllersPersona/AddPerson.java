package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddPerson {
    @Autowired
    PersonaService personaService;

    @CrossOrigin
    @PostMapping("/addperson")
    public void addPerson(@RequestBody PersonaInputDTO persona){
        personaService.crearPersona(persona);
    }
}
