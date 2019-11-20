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

    @PostMapping(value = "/properties")
    public Property create(@RequestBody Property property){
        repo.addProperty(property);
        return property;
    }


    @GetMapping(value = "/properties/{id}")
    public Property show(@PathVariable("id") int id){
        Property property = repo.getOne(id);
    return property;
    }


    @PostMapping(value = "/properties/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody Property newProperty){
        repo.updateProperty(id,newProperty);
    }


    @DeleteMapping(value = "/properties/{id}")
    public String delete(@PathVariable("id") int id){
        if(repo.propertyExists(id)){
            repo.deleteProperty(id);
            return "Property successfully deleted";
        } else {
            return "Property doesn't exist";
        }
    }


    
}