package de.ivev.mvc.controllers;

import de.ivev.mvc.dao.PersonDAO;
import de.ivev.mvc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonDAO personDAO;

    @Autowired
    public AdminController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") Person person){
        model.addAttribute("people", personDAO.index());
        return "admin";
    }

    @PatchMapping("/add")
    public String addAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());
        return "redirect:/admin";
    }

}
