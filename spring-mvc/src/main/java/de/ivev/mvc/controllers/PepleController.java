package de.ivev.mvc.controllers;

import de.ivev.mvc.dao.PersonDAO;
import de.ivev.mvc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PepleController {

    private final PersonDAO personDAO;

    @Autowired
    public PepleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person")Person person){
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person")Person person){
                int id = personDAO.index().size();
                personDAO.save(person);

                return "redirect:people";
    }

}
