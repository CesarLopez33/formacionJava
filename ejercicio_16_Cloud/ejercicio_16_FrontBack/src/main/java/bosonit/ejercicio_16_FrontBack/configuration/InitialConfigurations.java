package bosonit.ejercicio_16_FrontBack.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class InitialConfigurations {
    @Bean
    @LoadBalanced
    RestTemplate initRestTemplate(){
        return new RestTemplate();
    }
}
