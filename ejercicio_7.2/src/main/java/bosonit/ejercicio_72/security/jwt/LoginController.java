package bosonit.ejercicio_72.security.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Profile("security")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    Authentication authentication;

    @PostMapping
    public MyUser login(@RequestParam String username,@RequestParam String password) {
        return new MyUser(username,authentication.authenticate(username,password));
    }
}

