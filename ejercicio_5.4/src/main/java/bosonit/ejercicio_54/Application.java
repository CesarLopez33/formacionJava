package bosonit.ejercicio_54;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args){

		SpringApplication.run(Application.class, args);
	}
	@Value("${bd.url}")
	private String url;
	@Value("${environment}")
	private String env;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(env + "--> " + url);
	}

}
