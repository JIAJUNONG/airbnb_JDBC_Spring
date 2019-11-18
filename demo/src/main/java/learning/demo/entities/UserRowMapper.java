package learning.demo.entities;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet row, int rowNum) throws SQLException {
        User x = new User();
        // for each column in the DB, set 1 property on the java object
        // use getInt / getString / getBoolean depending on the column type in the DB
        x.setId(row.getInt("id"));
        x.setName(row.getString("name"));
        x.setContact_no(row.getString("contact_no"));
        x.setCreated_at(row.getTime("created_at"));
        x.setUpdated_at(row.getDate("updated_at"));
        return x;
    }
}