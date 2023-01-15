package de.ivev.FirstSecurityApp.services;

import de.ivev.FirstSecurityApp.models.Person;
import de.ivev.FirstSecurityApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final PersonRepository personRepository;

    @Autowired
    public RegistrationService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void register(Person person){
        personRepository.save(person);
    }
}
