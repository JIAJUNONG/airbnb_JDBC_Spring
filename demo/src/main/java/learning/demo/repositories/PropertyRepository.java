package learning.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.demo.entities.Property;
import learning.demo.entities.PropertyRowMapper;

@Transactional
@Repository
public class PropertyRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PropertyRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    public List<Property> getAll() {
        String sql = "SELECT * FROM [airbnb_dev].[dbo].[property]";
        RowMapper<Property> rowMapper = new PropertyRowMapper();
        // run sql query, convert SQL data into Java objects using rowmapper
        return this.jdbcTemplate.query(sql, rowMapper);
    }

}