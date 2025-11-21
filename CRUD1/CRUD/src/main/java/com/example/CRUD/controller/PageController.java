package com.example.CRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CRUD.model.Avenger;

import repos.AvengerRepo;

@Controller
public class PageController {
    private final AvengerRepo repo;

    public PageController(AvengerRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("avengers", repo.findAll());
        model.addAttribute("avenger", new Avenger());
        return "index";
    }

    // @PostMapping("/addAvenger")
    // public String addAvenger(@ModelAttribute Avenger avenger) {
    // System.out.println("Adding avenger: " + avenger.getName());
    // repo.save(avenger);
    // return "redirect:/";
    // }

    // @GetMapping("/delete/{id}")
    // public String deleteAvenger(@PathVariable long id) {
    //     repo.deleteById(id);
    //     return "redirect:/";
    // }

    // @GetMapping("/update/{id}")
    // public String updateAvenger(@PathVariable long id, Model model) {

    // Avenger avenger =repo.findById(id).orElse(new Avenger());
    // model.addAttribute("avenger", avenger);
    // return "update";
    // }

    // @PostMapping("/updateAvenger")
    // public String updateAvengerSubmit(@ModelAttribute Avenger avenger) {
    // System.out.println("Adding avenger: " + avenger.getName());
    // repo.save(avenger);
    // return "redirect:/";
    // }
}
