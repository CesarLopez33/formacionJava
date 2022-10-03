package bosonit.ejercicio_72;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {
	//Se incluyen varios ficheros de postaman para testeo
	//Fichero de pruebas para ejercicio 7.2: ejercicio_7.2.postman_collection.json
	//Fichero de pruebas para ejercicio 13.1: ejercicio_13.1.postman_collection.json

	//Se incluyen varios ficheros .run para la ejecucion
	//Ejercicio_10.1_docker para creacion jar
	//Application 8080/8081 para uso de diferentes puertos
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
