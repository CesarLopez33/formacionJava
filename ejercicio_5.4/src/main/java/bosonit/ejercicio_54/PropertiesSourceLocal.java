package bosonit.ejercicio_54;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:local.properties")
@Profile("local")
public class PropertiesSourceLocal {
}
