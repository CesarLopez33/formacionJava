package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class CrearPersona {

    @Autowired
    PersonaService ps;

    @PostMapping()
    void crearPersona(@RequestBody PersonaInputDTO p) {
        ps.crearPersona(p);
    }
}
