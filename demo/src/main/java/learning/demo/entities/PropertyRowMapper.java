package learning.demo.entities;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PropertyRowMapper implements RowMapper<Property> {
    @Override
    public Property mapRow(ResultSet row, int rowNum) throws SQLException {
        Property x = new Property();
        // for each column in the DB, set 1 property on the java object
        // use getInt / getString / getBoolean depending on the column type in the DB
        x.setId(row.getInt("id"));
        x.setAddress(row.getString("address"));
        x.setCreated_at(row.getTime("created_at"));
        x.setUpdated_at(row.getDate("updated_at"));
        x.setOwner_id(row.getInt("owner_id"));
        return x;
    }
}