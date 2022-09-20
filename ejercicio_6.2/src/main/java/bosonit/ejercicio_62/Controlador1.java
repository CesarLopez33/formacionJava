package bosonit.ejercicio_62;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/controlador1")
public class Controlador1 {

    @Autowired
    PersonaService ps;
    @Autowired
    List<Ciudad> ciudades;

    @GetMapping(value="addPersona")
    public Persona addPersona(@RequestHeader Map<String,String> mapa){
        Persona persona = ps.addNewPerson(mapa.get("nombre"),mapa.get("poblacion"),mapa.get("edad"));
        return persona;
    }

    @PostMapping(value="addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad){
        ciudades.add(ciudad);
        return ciudad;
    }
}
