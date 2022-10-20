package ru.alishev.springcourse.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.PersonRepository;

@Service
@Transactional(readOnly = true)
public class PersonService {
        private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> personOptional = repository.findById(id);
        return personOptional.orElse(null);
    }

    @Transactional
    public void savePerson(Person person){
        repository.save(person);
    }

    @Transactional
    public void updatePerson(int id, Person person){
        person.setId(id);
        repository.save(person);
    }

    @Transactional
    public void deletePerson(int id){
        repository.deleteById(id);
    }

    public void test(){
        System.out.println("testing");
    }
}