package learning.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.demo.entities.Booking;
import learning.demo.entities.BookingRowMapper;

@Transactional
@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Booking> getAll() {
        String sql = "SELECT * FROM [airbnb_dev].[dbo].[booking]";
        RowMapper<Booking> rowMapper = new BookingRowMapper();
        // run sql query, convert SQL data into Java objects using rowmapper
        return this.jdbcTemplate.query(sql, rowMapper);
    }


    public void addBooking (Booking booking){
        String sql = "INSERT INTO [airbnb_dev].[dbo].[booking] (price, booking_date, check_in, check_out, created_at, updated_at, user_id, property_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, booking.getPrice(), booking.getBooking_date(), booking.getCheck_in(), booking.getCheck_out(), booking.getCreated_at(), booking.getUpdated_at(), booking.getUser_id(), booking.getProperty_id());

        sql = "SELECT id FROM [airbnb_dev].[dbo].[booking] WHERE price = ? and booking_date = ? and check_in = ? and check_out = ? and created_at = ? and updated_at = ? and user_id = ? and property_id = ?";
        int bookingId = jdbcTemplate.queryForObject(sql, Integer.class, booking.getPrice(), booking.getBooking_date(), booking.getCheck_in(), booking.getCheck_out(), booking.getCreated_at(), booking.getUpdated_at(), booking.getUser_id(), booking.getProperty_id());

        booking.setId(bookingId);
    }

    public Booking getOne(int bookingId){
        String sql = "SELECT * FROM [airbnb_dev].[dbo].[booking] WHERE id = ?";
        RowMapper<Booking> rowMapper = new BookingRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, bookingId);
    }


    public void updateBooking(int bookingId, Booking booking){
        String sql = "UPDATE [airbnb_dev].[dbo].[booking] SET price = ? WHERE id = ?";
        jdbcTemplate.update(sql, booking.getPrice(), bookingId);
    }


    public Boolean bookingExists(int bookingId){
        String sql = "SELECT count(*) FROM [airbnb_dev].[dbo].[booking] WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, bookingId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteBooking(int bookingId){
        String sql = "DELETE FROM [airbnb_dev].[dbo].[booking] WHERE id = ?";
        jdbcTemplate.update(sql, bookingId);
    }

}