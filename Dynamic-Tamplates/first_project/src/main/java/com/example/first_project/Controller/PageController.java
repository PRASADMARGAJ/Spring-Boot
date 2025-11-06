package com.example.first_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
   @GetMapping("/")
   public String index(Model model) {
      model.addAttribute("name", "Tony Stark");
      model.addAttribute("herioc_name","Captain America");
    
   
   // if condition
   model.addAttribute("isHero", true);


   // if-else condition
 model.addAttribute("isHero", true);


//  if_else if_else(Switch Case)

model.addAttribute("herotype","avenger");


   return "index";
}
}