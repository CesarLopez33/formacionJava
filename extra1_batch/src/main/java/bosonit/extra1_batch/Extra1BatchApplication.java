package bosonit.extra1_batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Extra1BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Extra1BatchApplication.class, args);
	}

}
