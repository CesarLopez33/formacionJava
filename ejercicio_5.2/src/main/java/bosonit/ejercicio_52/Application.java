package bosonit.ejercicio_52;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value="classpath:application.yml")

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${greeting}")
	private String greeting;
	@Value("${my.number}")
	private int myNumber;
	@Value("${new.property:new.property no tiene valor}")
	private String newProperty;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("El valor de greeting es: " + greeting);
		System.out.println("El valor de my.number es: " + myNumber);
		System.out.println("El valor de new.property es: " + newProperty);
	}
}
