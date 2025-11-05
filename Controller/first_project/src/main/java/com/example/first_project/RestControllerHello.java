package com.example.first_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerHello {
    
    @GetMapping("/RestControllerHello")
    public String restHello(){
        return "Displaying Using Rest-Controller .";
    }
    
    }
   

