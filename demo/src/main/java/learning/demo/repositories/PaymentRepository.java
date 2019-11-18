package learning.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.demo.entities.Payment;
import learning.demo.entities.PaymentRowMapper;;

@Transactional
@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PaymentRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Payment> getAll() {
        String sql = "SELECT * FROM [airbnb_dev].[dbo].[payment]";
        RowMapper<Payment> rowMapper = new PaymentRowMapper();
        // run sql query, convert SQL data into Java objects using rowmapper
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}