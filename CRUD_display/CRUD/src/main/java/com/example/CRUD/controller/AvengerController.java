package com.example.CRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CRUD.model.Avenger;
import com.example.CRUD.repository.AvengerRepository;

@Controller
public class AvengerController {

    private final AvengerRepository repo;

    public AvengerController(AvengerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("avengers", repo.findAll());
        model.addAttribute("avenger", new Avenger());
        return "index";
    }

    @PostMapping("/addAvenger")
    public String addAvenger(@ModelAttribute Avenger avenger) {
        repo.save(avenger);
        return "redirect:/";
    }

    @GetMapping("/deleteAvenger/{id}")
    public String deleteAvenger(@PathVariable long id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/updateAvenger/{id}")
    public String updateAvenger(@PathVariable long id, Model model) {
        Avenger avenger = repo.findById(id).orElse(new Avenger());
        model.addAttribute(avenger);
        return "update";
    }

    @PostMapping("/updateAvenger")
    public String updateAvenger(@ModelAttribute Avenger avenger) {
        repo.save(avenger);
        return "redirect:/";
    }
}
