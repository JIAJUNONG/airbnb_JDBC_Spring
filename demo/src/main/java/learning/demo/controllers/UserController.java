package learning.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.demo.entities.User;
import learning.demo.entities.UserRowMapper;
import learning.demo.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping(value = "/users")
    public List<User> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user){
        repo.addUser(user);
        return user;
    }


    @GetMapping(value = "/users/{id}")
    public User show(@PathVariable("id") int id){
        User user = repo.getOne(id);
    return user;
    }


    @PostMapping(value = "/users/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody User newUser){
        repo.updateUser(id,newUser);
    }


    @DeleteMapping(value = "/users/{id}")
    public String delete(@PathVariable("id") int id){
        if(repo.userExists(id)){
            repo.deleteUser(id);
            return "User successfully deleted";
        } else {
            return "User doesn't exist";
        }
    }
    
}