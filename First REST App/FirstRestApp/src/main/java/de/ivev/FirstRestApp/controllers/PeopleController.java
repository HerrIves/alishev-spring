package de.ivev.FirstRestApp.controllers;

import de.ivev.FirstRestApp.models.Person;
import de.ivev.FirstRestApp.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
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
        Person one = peopleService.findOne(id);
        if (one==null) {
            one = new Person();
            one.setId(id);
            one.setName("no such person");
        }
        return one;
    }
}
