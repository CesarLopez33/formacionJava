package bosonit.ejercicio_132;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {
	//Nombre db: testMongoDB
	//Username: myuser
	//Password: bosonit
	//Ejercicio de crud sobre persona usando mongoTemplate
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
