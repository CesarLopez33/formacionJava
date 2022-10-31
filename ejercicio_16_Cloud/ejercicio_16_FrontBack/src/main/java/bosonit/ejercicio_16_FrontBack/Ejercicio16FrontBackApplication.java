package bosonit.ejercicio_16_FrontBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ejercicio16FrontBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16FrontBackApplication.class, args);
	}

}
