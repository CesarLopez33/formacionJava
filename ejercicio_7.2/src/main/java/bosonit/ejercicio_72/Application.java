package bosonit.ejercicio_72;

import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class Application implements CommandLineRunner{
	//Se incluyen varios ficheros de postaman para testeo:
	//Fichero de pruebas para ejercicio 7.2: ejercicio_7.2.postman_collection.json
	//Fichero de pruebas para ejercicio 13.1: ejercicio_13.1.postman_collection.json
	//Fichero de pruebas para ejercicio 15.1 seguridad: seguridad.postman_collection.json

	//Se incluyen varios ficheros .run para la ejecucion:
	//Application 8080/8081 para uso de diferentes puertos para restTemplate y Feign
	//Ejercicio_10.1_docker para creacion jar
	//Ejercicio_14.1-testing.run para testing y sonarqube

	//Security -> utiliza seguridad (paquete security.jwt) (Primera forma de hacerlo)(El programa actualmente encripta
	// las contraseñas asique este metodo ya no funciona, pero lo he dejado para que se vea que hay mas formas de hacerlo)
	//Security2 -> utiliza seguridad (paquete segunda.jwt) (Segunda forma de hacerlo)

	//Se ha añadido el fichero lombok.cofig para que sonarqube no tenga en cuenta las etiquetas de esta dependencia
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	PersonaService personaService;


	@Override //Creo una persona admin para las pruebas
	public void run(String... args) throws Exception {
		personaService.crearPersona(new PersonaInputDTO("Juanes",
				"aaa",
				"Perez",
				"dasdas",
				"asdasdasd",
				"asdasdasd2",
				"Madrid",
				true,
				new Date(2001-12-27),
				"asdasdasd.com",
				new Date(2003-11-23),
				true));
	}
}
