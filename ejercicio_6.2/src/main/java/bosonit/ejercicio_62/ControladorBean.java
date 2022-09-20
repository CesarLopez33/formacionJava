package bosonit.ejercicio_62;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/controlador/bean")
public class ControladorBean {

    @Autowired
    @Qualifier("bean1")
    Persona persona1;
    @Autowired
    @Qualifier("bean2")
    Persona persona2;
    @Autowired
    @Qualifier("bean3")
    Persona persona3;

    @GetMapping(value="bean1")
    public Persona bean1(){
        return persona1;
    }
    @GetMapping(value="bean2")
    public Persona bean2(){
        return persona2;
    }
    @GetMapping(value="bean3")
    public Persona bean3(){
        return persona3;
    }

}
