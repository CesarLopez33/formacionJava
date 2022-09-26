package bosonit.ejercicio_72.persona.controllersPersona;

import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persona")
public class ObtenerPersona {

    @Autowired
    PersonaService ps;

    @GetMapping("/{id}")
    ResponseEntity obtenerPersona(@PathVariable Integer id,
                                  @RequestParam(defaultValue = "simple") String outputType) {
        if(outputType.equals("simple")) return new ResponseEntity(ps.obtenerPersona(id), HttpStatus.OK);
        else if (outputType.equals("full")) return ps.obtenerPersonaConTodo(id);
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/nombre/{nombre}")
    ResponseEntity obtenerPersonaPorNombre(@PathVariable String nombre,
                                          @RequestParam(defaultValue = "simple") String outputType) {
        if(outputType.equals("simple")) return new ResponseEntity<>(ps.obtenerPersonaPorNombre(nombre),HttpStatus.OK);
        else if (outputType.equals("full")) return ps.obtenerPersonaPorNombreConTodo(nombre);
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/all")
    ResponseEntity obtenerTodasPersonas(@RequestParam(defaultValue = "simple") String outputType) {
        if(outputType.equals("simple")) return new ResponseEntity<>(ps.obtenerTodasPersonas(),HttpStatus.OK);
        else if (outputType.equals("full")) return ps.obtenerTodasPersonaConTodo();
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
}
