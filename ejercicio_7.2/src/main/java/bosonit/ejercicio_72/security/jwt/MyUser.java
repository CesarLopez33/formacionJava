package bosonit.ejercicio_72.security.jwt;

import lombok.Data;

@Data
public class MyUser {
    private String username;
    private String token;

    MyUser(String username,String token){
        this.username=username;
        this.token=token;
    }
}
