package learning.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.demo.entities.Payment;
import learning.demo.entities.PaymentRowMapper;
import learning.demo.repositories.PaymentRepository;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository repo;

    @GetMapping(value = "/payments")
    public List<Payment> index() {
        return repo.getAll();
    }


    
}