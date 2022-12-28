package utils;

import models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        return Person.builder()
                .id(resultSet.getInt("ID"))
                .name(resultSet.getString("NAME"))
                .age(resultSet.getInt("AGE"))
                .build();
    }
}
