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

    @PostMapping(value = "/bookings")
    public Booking create(@RequestBody Booking booking){
        repo.addBooking(booking);
        return booking;
    }

    @GetMapping(value = "/bookings/{id}")
    public Booking show(@PathVariable("id") int id){
        Booking booking = repo.getOne(id);
    return booking;
    }

    @PostMapping(value = "/bookings/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody Booking newBooking){
        repo.updateBooking(id,newBooking);
    }


    @DeleteMapping(value = "/bookings/{id}")
    public String delete(@PathVariable("id") int id){
        if(repo.bookingExists(id)){
            repo.deleteBooking(id);
            return "Booking successfully deleted";
        } else {
            return "Booking doesn't exist";
        }
    }


    
}