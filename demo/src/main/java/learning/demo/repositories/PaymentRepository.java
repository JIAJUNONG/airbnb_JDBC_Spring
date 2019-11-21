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

    public void addPayment (Payment payment){
        String sql = "INSERT INTO [airbnb_dev].[dbo].[payment] (status, amount, created_at, updated_at, booking_id ) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, payment.getStatus(), payment.getAmount(), payment.getCreated_at(), payment.getUpdated_at(), payment.getBooking_id());

        sql = "SELECT id FROM [airbnb_dev].[dbo].[payment] WHERE status = ? and amount = ? and created_at = ? and updated_at = ? and booking_id = ?";
        int paymentId = jdbcTemplate.queryForObject(sql, Integer.class, payment.getStatus(), payment.getAmount(), payment.getCreated_at(), payment.getUpdated_at(), payment.getBooking_id());

        payment.setId(paymentId);
    }

    public Payment getOne(int paymentId){
        String sql = "SELECT * FROM [airbnb_dev].[dbo].[payment] WHERE id = ?";
        RowMapper<Payment> rowMapper = new PaymentRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, paymentId);
    }


    public void updatePayment(int paymentId, Payment payment){
        String sql = "UPDATE [airbnb_dev].[dbo].[payment] SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, payment.getStatus(), paymentId);
    }


    public Boolean paymentExists(int paymentId){
        String sql = "SELECT count(*) FROM [airbnb_dev].[dbo].[payment] WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, paymentId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void deletePayment(int paymentId){
        String sql = "DELETE FROM [airbnb_dev].[dbo].[payment] WHERE id = ?";
        jdbcTemplate.update(sql, paymentId);
    }

}