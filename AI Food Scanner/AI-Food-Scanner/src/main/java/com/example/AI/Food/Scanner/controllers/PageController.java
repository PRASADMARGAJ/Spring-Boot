package com.example.AI.Food.Scanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/alerts")
    public String alerts() {
        return "alerts";
    }

    @GetMapping("/results")
    public String results() {
        return "results";
    }

    @GetMapping("/scan")
    public String scan() {
        return "scan";
    }

      @GetMapping("/login")
    public String login() {
        return "login";
    }
}
