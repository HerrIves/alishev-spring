package de.ivev.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OneMoreController {
    @GetMapping("one-more")
    public String sayHelloOneMoreTime(){
        return "one-more";
    }
}
