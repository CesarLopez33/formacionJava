package bosonit.ejercicio_121;

import bosonit.ejercicio_121.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {
    @Autowired
    @Qualifier("kafkaStringTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    @Qualifier("kafkaPersonaTemplate")
    private KafkaTemplate<String,PersonaDTO> kafkaTemplatePersona;
    @Value(value = "${kafka.topic.name}")
    private String topic;

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Message has been sent to client: "+ message);
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Something went wrong with the message: "+ ex.getMessage());
            }
        });
    }

    public PersonaDTO sendPersona(PersonaDTO persona){
        ListenableFuture<SendResult<String,PersonaDTO>> future = kafkaTemplatePersona.send(topic, persona);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, PersonaDTO> result) {
                System.out.println("Message has been sent to client");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Something went wrong with the message: "+ ex.getMessage());
            }
        });
        return persona;
    }

}