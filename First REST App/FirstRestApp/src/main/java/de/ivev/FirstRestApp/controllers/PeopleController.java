package de.ivev.FirstRestApp.controllers;

import de.ivev.FirstRestApp.models.Person;
import de.ivev.FirstRestApp.services.PeopleService;
import de.ivev.FirstRestApp.utils.PersonErrorResponse;
import de.ivev.FirstRestApp.utils.PersonNotCreatedException;
import de.ivev.FirstRestApp.utils.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<HttpStatus> create(
            @RequestBody @Valid Person person, BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(
                    error -> errorMsg.append(error.getField() + " - " + error.getDefaultMessage()));
            throw new PersonNotCreatedException(errorMsg.toString());
        }

        peopleService.save(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> exceptionHandler(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse(
                "no such id user found", System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> exceptionHandler(PersonNotCreatedException e){
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
