package bosonit.ejercicio_72.security.jwt;

import bosonit.ejercicio_72.exceptions.UnprocessableEntityException;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Authentication {
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public String authenticate(String username, String password) {
        String secretKey = "mySecretKey";

        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        password=passwordEncoder.encode(password);
        //Buscamos a la persona en el repositorio
        Persona persona = personaRepository.findFirstByUsuario(username);
        //Si no existe lanzamos excepcion
        if(persona==null) throw new EntityNotFoundException("Persona no encontrada");
        //Comprobamos constrasena y permisos de admin
        if((persona.getPassword()).equals(password)) {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (persona.getAdmin())
                grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else{
            throw new UnprocessableEntityException("Constrasena incorrecta");
        }

        return Jwts.builder()
                .setSubject(username) //whom the token refers to
                .claim("authorities", grantedAuthority.stream().map(GrantedAuthority::getAuthority).toList())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()) //sign algorithm
                .compact();
    }
}
