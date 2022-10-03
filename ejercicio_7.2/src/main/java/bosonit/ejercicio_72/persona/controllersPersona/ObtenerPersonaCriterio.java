package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/persona/criterio")
public class ObtenerPersonaCriterio {
    @Autowired
    PersonaService personaService;

    @GetMapping
    public List<PersonaOutputDTO> obtenerPersonaPorCriterio(@RequestParam("num_page") int numPage,
                                                   @RequestParam(value = "page_size",defaultValue = "10") int pageSize,
                                                   @RequestParam HashMap<String,Object> condiciones) {
        return personaService.obtenerPersonaPorCriterio(condiciones,numPage,pageSize);
    }
}
