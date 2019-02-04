package api.controller;

import api.model.User;
import api.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

//    localhost:8080/api/1
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return service.getUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public void saveUser(@RequestBody User user) {
        service.saveUser(user);
    }

//    localhost:8080/api?date=2017-10-10&name=John
    @GetMapping("/find")
    public List<User> findAllByBirthDateAndAndName(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam String name) {
        return service.findAllByBirthDateAndAndName(date, name);
    }

    @GetMapping("/find_by_name")
    public List<User> findAllByNameCustom(@RequestParam String name) {
        return service.findAllByNameCustom(name);
    }

    @GetMapping("/find_by_email")
    public List<User> findAllByEmail(@RequestParam String email) {
        return service.findAllByEmailCustom(email);
    }

}