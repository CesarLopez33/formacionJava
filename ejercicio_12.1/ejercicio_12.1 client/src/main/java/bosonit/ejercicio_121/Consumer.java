package bosonit.ejercicio_121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class Consumer {
    @Autowired
    Producer producer;

    @KafkaListener(topics = "${kafka.topic.name}")
    public void listenTestTopic(String message) {
        System.out.println("Message received: " + message);
        producer.sendResponse("responses","The message was correctly received, thank you");
    }

}