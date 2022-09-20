package bosonit.ejercicio_63;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    UserService us;

    @PostMapping(value="post")
    public User createUser(@RequestBody User u){
        us.addNewUser(u);
        return u;
    }

    @GetMapping(value="user/{id}")
    public User devolverUser(@PathVariable Integer id){
        return us.getUser(id);
    }

    @PutMapping(value="post")
    public User putUser(@RequestParam("var1") Integer id, @RequestParam("var2") String name){
        return us.updateUser(id,name);
    }
}
