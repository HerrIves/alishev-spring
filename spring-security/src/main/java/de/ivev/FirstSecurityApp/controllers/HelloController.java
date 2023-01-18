package de.ivev.FirstSecurityApp.controllers;

import de.ivev.FirstSecurityApp.security.PersonDetails;
import de.ivev.FirstSecurityApp.services.SecurityAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
    private final SecurityAdminService adminService;

    @Autowired
    public HelloController(SecurityAdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getuser")
    public String getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "redirect:/hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.callAdmin();

        return "admin";
    }
}
