package learning.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.demo.entities.Booking;
import learning.demo.entities.BookingRowMapper;
import learning.demo.repositories.BookingRepository;

@RestController
public class BookingController {

    @Autowired
    BookingRepository repo;

    @GetMapping(value = "/bookings")
    public List<Booking> index() {
        return repo.getAll();
    }


    
}