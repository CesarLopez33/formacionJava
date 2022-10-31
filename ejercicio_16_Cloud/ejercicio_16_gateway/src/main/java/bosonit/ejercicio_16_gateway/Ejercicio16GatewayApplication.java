package bosonit.ejercicio_16_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Ejercicio16GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio16GatewayApplication.class, args);
	}

}
