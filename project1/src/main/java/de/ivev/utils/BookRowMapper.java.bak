package utils;

import models.Book;
import models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        return Book.builder()
                .id(resultSet.getInt("ID"))
                .name(resultSet.getString("NAME"))
                .author(resultSet.getString("AUTHOR"))
                .year(resultSet.getInt("YEAR"))
                .owner(resultSet.getObject("OWNER", Person.class))
                .build();
    }
}
