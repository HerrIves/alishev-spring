package de.ivev.services;

import de.ivev.models.Person;
import de.ivev.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findOne(int id){
        return personRepository.getOne(id);
    }



    public Optional<Person> getPersonByFullName(String fullName) {
        return null;
    }
}
