package bosonit.ejercicio_51;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FormacionApplication implements CommandLineRunner{

	public static void main(String[] args){
		System.out.println("Iniciando aplicacion");
		SpringApplication.run(FormacionApplication.class, args);
		System.out.println("Terminando aplicacion");
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@PostConstruct
	public void ejecutaPrimero(){
		System.out.println("Hola desde la clase inicial");
	}

	@Bean
	CommandLineRunner ejecutaSegundo(){
		return p->{
			System.out.println("Hola desde la clase secundaria");
		};
	}
	@Bean
	CommandLineRunner ejecutaTercero(){
		return p->{
			System.out.println("Soy la tercera clase");
			for (String valor : p)
				System.out.println(valor);
		};
	}
}
