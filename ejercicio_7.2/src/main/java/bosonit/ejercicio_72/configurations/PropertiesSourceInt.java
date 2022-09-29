package bosonit.ejercicio_72.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:postgres.properties")
@Profile("INT")
public class PropertiesSourceInt {
}