package de.ivev.mvc.dao;

import de.ivev.mvc.models.Person;
import org.springframework.stereotype.Component;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "root";

    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index(){
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";

            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    public Person show(int id){
//        return people.stream()
//                .filter(person -> person.getId() == id)
//                .findAny().orElse(new Person(0, "NULL", 0, "NULL"));
        return null;
    }

    public void save(Person person) {
//        person.setId(++peopleCount);
//        people.add(person);

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName()
                    + "'," + person.getAge() + ",'" + person.getEmail() + "')";
            statement.executeUpdate(SQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person person) {
//        Person person2Update = show(id);
//        person2Update.setName(person.getName());
//        person2Update.setAge(person.getAge());
//        person2Update.setEmail(person.getEmail());
    }

    public void delete(int id) {
//        Person person4Delete = show(id);
//        people.remove(person4Delete);
    }
}
