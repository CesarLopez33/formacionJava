package bosonit.ejercicio_72.persona.controllers.persona.cors;

import bosonit.ejercicio_72.persona.dtos.PersonaCorsOutputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAll {
    @Autowired
    PersonaService personaService;

    @CrossOrigin
    @GetMapping("/getall")
    public List<PersonaCorsOutputDTO> getAll(){
        return personaService.obtenerTodasPersonas().stream().map(PersonaCorsOutputDTO::new).toList();
    }

}
