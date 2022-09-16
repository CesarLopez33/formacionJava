package bosonit.ejercicio_53;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.trace("Mensaje a nivel de TRACE");
		log.debug("Mensaje a nivel de DEBUG");
		log.info("Mensaje a nivel de INFO");
		log.warn("Mensaje a nivel de WARNING");
		log.error("Mensaje a nivel de ERROR");
	}
	//Los logs de nivel "error" están en logs/spring-logging.log
	//Archivo de configuracion: log4j2-spring.xml


}

