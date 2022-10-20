package ru.alishev.springcourse.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String Name);

    List<Person> findByNameOrderByAge(String Name);

    List<Person> findByNameStartingWith(String startingWith);

    List<Person> findByNameAndEmail(String name, String Email);

    List<Person> findByNameOrEmail(String name, String email);
}
