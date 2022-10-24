package bosonit.ejercicio_72.security.segunda;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = personaRepository.findFirstByUsuario(username);
        if(persona==null) throw new UsernameNotFoundException("Usuario no encontrado");

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if(persona.getAdmin())
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(persona.getUsuario(),persona.getPassword(),authorities);
    }
}
