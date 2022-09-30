package bosonit.ejercicio_121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
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

}