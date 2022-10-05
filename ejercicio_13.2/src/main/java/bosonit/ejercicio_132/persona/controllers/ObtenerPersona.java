package bosonit.ejercicio_132.persona.controllers;

import bosonit.ejercicio_132.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_132.persona.personaServices.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persona")
public class ObtenerPersona {
    @Autowired
    PersonaService ps;

    @GetMapping("/{id}")
    public PersonaOutputDTO obtenerPersona(@PathVariable Integer id){
        return ps.obtenerPersona(id);
    }
    @GetMapping("/all")
    public List<PersonaOutputDTO> obtenerTodasPersonas(){
        return ps.obtenerTodasPersonas();
    }
    @GetMapping("/allPaginated")
    public List<PersonaOutputDTO> obtenerTodasPersonasPaginada(@RequestParam("pageSize") int pageSize,
                                                               @RequestParam("numPage") int numPage){
        return ps.obtenerTodasPersonasPaginada(pageSize,numPage);
    }
}
