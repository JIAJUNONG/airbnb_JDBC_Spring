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


    
}