package bosonit.ejercicio_16_Cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ejercicio16CloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16CloudApplication.class, args);
	}

}
