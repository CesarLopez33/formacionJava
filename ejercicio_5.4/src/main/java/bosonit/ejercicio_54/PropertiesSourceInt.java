package bosonit.ejercicio_54;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:INT.properties")
@Profile("INT")
public class PropertiesSourceInt {
}
