package bosonit.ejercicio_121;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics="responses")
    public void recibirRespuestas(String response){
        System.out.println("Response received from client: "+ response);
    }
}
