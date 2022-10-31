package bosonit.ejercicio_121;

import bosonit.ejercicio_121.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    Producer producer;

    @PostMapping("/send")
    public void enviarMensaje(@RequestBody String message){
        producer.sendMessage(message);
    }

    @PostMapping("/send/persona")
    public PersonaDTO enviarPersona(@RequestBody PersonaDTO personaDTO){
        return producer.sendPersona(personaDTO);
    }
}
