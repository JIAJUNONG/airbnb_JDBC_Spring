package learning.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.demo.entities.Property;
import learning.demo.entities.PropertyRowMapper;
import learning.demo.repositories.PropertyRepository;

@RestController
public class PropertyController {

    @Autowired
    PropertyRepository repo;

    @GetMapping(value = "/properties")
    public List<Property> index() {
        return repo.getAll();
    }


    
}