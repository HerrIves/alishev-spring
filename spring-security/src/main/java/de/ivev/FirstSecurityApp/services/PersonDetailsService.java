package de.ivev.FirstSecurityApp.services;

import de.ivev.FirstSecurityApp.models.Person;
import de.ivev.FirstSecurityApp.repositories.PersonRepository;
import de.ivev.FirstSecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> byUsername = personRepository.findByUsername(s);

        if (byUsername.isEmpty())throw new UsernameNotFoundException("User not found");

        return new PersonDetails(byUsername.get());
    }
}
