package api.service;

import api.exceptions.WrongAgeException;
import api.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService {

//    private static final HashMap<Integer, User> users = new HashMap<>();
//
//    static {
//        users.put(1, new User(1, "John", 22));
//    }

    public void saveUser(User user) {
        if (user.getAge() > 150) {
            throw new WrongAgeException("Age is wrong!");
        }
        else System.out.println(user);
    }

    public User getUser(Integer id) {
        if (id == 1) {
            User user = new User();
            user.setName("John");
            user.setAge(25);
            return user;
        }
        return null;
    }
}
