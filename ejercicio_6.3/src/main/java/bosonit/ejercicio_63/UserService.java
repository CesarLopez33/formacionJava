package bosonit.ejercicio_63;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    List<User> userList;

    public void addNewUser(User u){
        userList.add(u);
    }
    public User getUser(Integer id){
        for (User u:userList){
            if (u.getId().equals(id))
                    return u;
        }
        return null;
    }
    public User updateUser(Integer id, String name){
        for (User u:userList){
            if (u.getId().equals(id)) {
                u.setName(name);
                return u;
            }
        }
        return null;
    }
}
