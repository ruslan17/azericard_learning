package api.service;

import api.model.User;
import api.repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public User getUser(Integer id) {
       return repository.findById(id).orElseThrow(() -> new RuntimeException("No such user!"));
    }

    public List<User> findAllByBirthDateAndAndName(LocalDate date, String name) {
        return repository.findAllByBirthDateAndAndName(date, name);
    }

    public List<User> findAllByNameCustom(String name) {
        return repository.findAllByName(name);
//        return null;
    }

    public List<User> findAllByEmailCustom(String email) {
        return repository.findAllByEmailCustom(email);
    }
}