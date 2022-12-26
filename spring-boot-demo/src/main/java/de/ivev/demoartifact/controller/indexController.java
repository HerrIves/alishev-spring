package de.ivev.demoartifact.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;


@Controller
public class indexController {
    @Value("${hello}")
    private String hello;


    @GetMapping("/second")
    public String index(){
        return "second";
    }
}
