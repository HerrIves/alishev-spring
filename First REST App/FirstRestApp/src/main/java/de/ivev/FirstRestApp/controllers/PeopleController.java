package de.ivev.FirstRestApp.controllers;

import de.ivev.FirstRestApp.models.Person;
import de.ivev.FirstRestApp.services.PeopleService;
import de.ivev.FirstRestApp.utils.PersonErrorResponse;
import de.ivev.FirstRestApp.utils.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> findAll(){
        return peopleService.findAll();
    }


    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id){
        return peopleService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> exceptionHandler(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse(
                "no such id user found", System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
