package bosonit.ejercicio_16_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Ejercicio16EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16EurekaApplication.class, args);
	}

}
