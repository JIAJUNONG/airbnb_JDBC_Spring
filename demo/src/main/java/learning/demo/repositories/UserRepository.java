package learning.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.demo.entities.User;
import learning.demo.entities.UserRowMapper;;

@Transactional
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll() {
        String sql = "SELECT * FROM [airbnb_dev].[dbo].[user]";
        RowMapper<User> rowMapper = new UserRowMapper();
        // run sql query, convert SQL data into Java objects using rowmapper
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}