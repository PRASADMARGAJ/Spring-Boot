package com.example.first_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/WebHello")
    public String WebHello(){
        return "Hello";
    }
    
}
