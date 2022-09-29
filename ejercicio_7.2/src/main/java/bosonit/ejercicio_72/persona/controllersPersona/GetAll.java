package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAll {
    @Autowired
    PersonaService personaService;

    @CrossOrigin
    @GetMapping("/getall")
    public List<PersonaOutputDTO> getAll(){
        return personaService.obtenerTodasPersonas();
    }

}
