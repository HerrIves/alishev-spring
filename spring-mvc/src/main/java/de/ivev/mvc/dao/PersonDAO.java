package de.ivev.mvc.dao;

import de.ivev.mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount, "Tom", 20, "tom@mail.com"));
        people.add(new Person(++peopleCount, "Bob", 31, "bob@mail.com"));
        people.add(new Person(++peopleCount, "Mike", 41, "mike@mail.com"));
        people.add(new Person(++peopleCount, "Katy", 34, "katy@mail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(new Person(0, "NULL", 0, "NULL"));
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person person2Update = show(id);
        person2Update.setName(person.getName());
        person2Update.setAge(person.getAge());
        person2Update.setEmail(person.getEmail());

    }
}
