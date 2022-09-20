package bosonit.ejercicio_63;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfiguration {

    @Bean
    public List<User> creaListaUser(){
        List<User> userList = new ArrayList<>();
        User u1 = new User(1,"Juan");
        userList.add(u1);
        User u2 = new User(2,"Manuel");
        userList.add(u2);
        User u3 = new User(3,"Alberto");
        userList.add(u3);
        return userList;
    }
}
