package controllers;

import dao.PersonDAO;
import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JDBCTemplateController {

    private PersonDAO personDAO;

    @Autowired
    JDBCTemplateController(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String home(@PathVariable int id){
        Person person = personDAO.readPerson(id);

        return person.toString();
    }
}
