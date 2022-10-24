package bosonit.ejercicio_72.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:security.properties")
@Profile({"security","security2"})
public class PropertiesSourceSecurity {
}
