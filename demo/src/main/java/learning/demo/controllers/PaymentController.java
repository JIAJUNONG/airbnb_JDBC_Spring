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


    @PostMapping(value = "/payments")
    public Payment create(@RequestBody Payment payment){
        repo.addPayment(payment);
        return payment;
    }


    @GetMapping(value = "/payments/{id}")
    public Payment show(@PathVariable("id") int id){
        Payment payment = repo.getOne(id);
    return payment;
    }


    @PostMapping(value = "/payments/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody Payment newPayment){
        repo.updatePayment(id,newPayment);
    }


    @DeleteMapping(value = "/payments/{id}")
    public String delete(@PathVariable("id") int id){
        if(repo.paymentExists(id)){
            repo.deletePayment(id);
            return "Payment successfully deleted";
        } else {
            return "Payment doesn't exist";
        }
    }


    
}