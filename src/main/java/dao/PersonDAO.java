package dao;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import utils.PersonRowMapper;

import java.sql.SQLException;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createPerson(Person person) throws SQLException {

        return 0;
    }

    public Person readPerson(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE Id = ?", new PersonRowMapper(), new Object[]{id});
    }

    public void updatePerson(Person person) {

    }

    public void deletePerson(Person person) {
    }
}
