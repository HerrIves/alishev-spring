package de.ivev.FirstRestApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
@RequestMapping("/api")
public class FirstRESTController {

    @GetMapping
    @ResponseBody
    public String sayHello(){
        return "hello";
    }
}
