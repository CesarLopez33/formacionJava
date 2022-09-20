package bosonit.ejercicio_62;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigurationAplication {

    @Bean
    @Primary
    public Persona creaPersona(){
        return new Persona();
    }

    @Bean
    public List<Ciudad> creaListaCiudades(){
        List<Ciudad> ciudades = new ArrayList<>();
        Ciudad a = new Ciudad("Logroño",150000);
        ciudades.add(a);
        Ciudad b = new Ciudad("Valencia",791000);
        ciudades.add(b);
        Ciudad c = new Ciudad("Alicante",331000);
        ciudades.add(c);
        return ciudades;
    }

    @Bean
    @Qualifier(value="bean1")
    public Persona bean1(){
        Persona p = new Persona("ALberto","Huelva",80);
        return p;
    }
    @Bean
    @Qualifier(value="bean2")
    public Persona bean2(){
        Persona p = new Persona("Juan","Albacete",47);
        return p;
    }
    @Bean
    @Qualifier(value="bean3")
    public Persona bean3(){
        Persona p = new Persona("Francisco","Madrid",32);
        return p;
    }
}
