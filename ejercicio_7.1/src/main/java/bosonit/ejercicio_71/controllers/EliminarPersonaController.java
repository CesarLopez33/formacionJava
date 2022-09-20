package bosonit.ejercicio_71.controllers;

import bosonit.ejercicio_71.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/persona")
public class EliminarPersonaController {
    @Autowired
    PersonaService ps;

    @DeleteMapping(value="{id}")
    public void eliminarPersona(@PathVariable String id){
        ps.eliminarPersona(id);
    }
}
