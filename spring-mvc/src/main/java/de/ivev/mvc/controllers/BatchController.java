package de.ivev.mvc.controllers;

import de.ivev.mvc.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test-batch-update")
public class BatchController {

    private final PersonDAO personalDAO;
    @Autowired
    public BatchController(PersonDAO personalDAO) {        this.personalDAO = personalDAO;    }


    @GetMapping
    public String index(){
        return "batch/index";
    }

    @GetMapping("/without")
    public String without(){
        personalDAO.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String with(){
        personalDAO.testBatchUpdate();
        return "redirect:/people";
    }
}
