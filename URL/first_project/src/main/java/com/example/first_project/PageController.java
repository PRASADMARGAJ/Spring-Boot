package com.example.first_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/product/{id}")
    public String product(@PathVariable int id , Model model){
        System.out.println("Product Id :" +id);
       model.addAttribute("Product_id", id);
        return "product";

    }
}
