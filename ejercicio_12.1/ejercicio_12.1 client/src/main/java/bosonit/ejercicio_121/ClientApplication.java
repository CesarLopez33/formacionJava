package bosonit.ejercicio_121;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ClientApplication {
	//La aplicacion server envia un mensaje a la aplicacion cliente en el topic "test" y esta segunda responde con un
	// mensaje en el topic "responses"
	//Server envia el mensaje recibido en el body de http://localhost:8080/send
	//(ver fichero postman en carpeta principal)
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
