package bosonit;

import bosonit.storageService.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio_133 implements CommandLineRunner {
	//Adjunto fichero ejercicio_13.3.postman_collection para pruebas
	//En la carpeta /run se encuentran las configuraciones para ejecutar el programa con o sin parametro de entrada
	//La carpeta de guardado de ficheros predeterminada es /upload
	//Se utiliza base de datos h2 con ruta: ~/db133/ejercicio133

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio_133.class, args);
	}
	@Autowired
	StorageService storageService;

	@Override
	public void run(String... args) {
	}

	@Bean
	CommandLineRunner init(){
		return (args)-> {
			if (args.length > 0)
				storageService.setRootLocation(args[0]);
			else
				storageService.setRootLocation("upload");
			storageService.deleteAll();
			storageService.init();
		};
	}
}
