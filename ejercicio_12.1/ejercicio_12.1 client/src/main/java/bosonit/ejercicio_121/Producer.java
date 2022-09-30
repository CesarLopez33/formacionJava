package bosonit.ejercicio_121;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void sendResponse(String topic, String message){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Response has been sent to server: "+ message);
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Something went wrong with the response: "+ ex.getMessage());
            }
        });

    }
}
