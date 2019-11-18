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

}