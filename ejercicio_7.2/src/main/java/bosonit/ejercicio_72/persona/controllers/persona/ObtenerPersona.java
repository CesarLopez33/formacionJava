package bosonit.ejercicio_72.persona.controllers.persona;

import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persona")
public class ObtenerPersona {

    private String modeSimple= "simple";
    private String modeFull = "full";
    @Autowired
    PersonaService ps;

    @GetMapping("/{id}")
    ResponseEntity<Object> obtenerPersona(@PathVariable Integer id,
                                  @RequestParam(defaultValue = "simple") String outputType) {
        if(outputType.equals(modeSimple))
            return new ResponseEntity<Object>(ps.obtenerPersona(id), HttpStatus.OK);
        else if (outputType.equals(modeFull))
            return ps.obtenerPersonaConTodo(id);
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/nombre/{nombre}")
    ResponseEntity<Object> obtenerPersonaPorNombre(@PathVariable String nombre,
                                          @RequestParam(defaultValue = "simple") String outputType) {
        if(outputType.equals(modeSimple))
            return new ResponseEntity<>(ps.obtenerPersonaPorNombre(nombre),HttpStatus.OK);
        else if (outputType.equals(modeFull))
            return ps.obtenerPersonaPorNombreConTodo(nombre);
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/all")
    ResponseEntity<Object> obtenerTodasPersonas(@RequestParam(defaultValue = "simple") String outputType) {
        if(outputType.equals(modeSimple))
            return new ResponseEntity<>(ps.obtenerTodasPersonas(),HttpStatus.OK);
        else if (outputType.equals(modeFull))
            return ps.obtenerTodasPersonaConTodo();
        else return new ResponseEntity<>("Parametros mal introducidos",HttpStatus.BAD_REQUEST);
    }
}
