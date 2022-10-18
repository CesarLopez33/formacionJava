package bosonit.ejercicio_72;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {
	//Se incluyen varios ficheros de postaman para testeo:
	//Fichero de pruebas para ejercicio 7.2: ejercicio_7.2.postman_collection.json
	//Fichero de pruebas para ejercicio 13.1: ejercicio_13.1.postman_collection.json

	//Se incluyen varios ficheros .run para la ejecucion:
	//Application 8080/8081 para uso de diferentes puertos para restTemplate y Feign
	//Ejercicio_10.1_docker para creacion jar
	//Ejercicio_14.1-testing.run para testing y sonarqube

	//Se ha añadido el fichero lombok.cofig para que sonarqube no tenga en cuenta las etiquetas de esta dependencia
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
