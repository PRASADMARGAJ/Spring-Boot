package com.example.first_project.Controller;

import com.example.first_project.model.Watch;
import com.example.first_project.model.enums.Catgeries;
import com.example.first_project.repository.WatchRepo;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/pets")
public class WatchController {
     private final WatchRepo watchRepo;

    public WatchController(WatchRepo watchRepo) {
        this.watchRepo = watchRepo;
    }

    @GetMapping
    public String viewPets(Model model) {
        model.addAttribute("watchRepo",watchRepo.findAll());
        return "admin/pet/view_pet";
    }

    @GetMapping("/add")
    public String addPetForm(Model model) {
        model.addAttribute("watch", new Watch());
        model.addAttribute("categories",Catgeries.values());
        return "admin/pet/add_pet";
    }

    @PostMapping("/add")
    public String addPet(@ModelAttribute Watch pet,
                         @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            pet.Images(imageFile.getBytes());
        }

        watchRepo.save(pet);
        return "redirect:/admin/pets";
    }

    @GetMapping("/update/{id}")
    public String updatePetForm(@PathVariable Long id, Model model) {
        Watch watch = watchRepo.findById(id).orElse(new watch());
        model.addAttribute("watch", watch);
        model.addAttribute("categories", Catgeries.values());
        return "admin/pet/update_pet";
    }

    @PostMapping("/update")
    public String updatePet(@ModelAttribute Watch watch,
                            @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            watch.Images(imageFile.getBytes());
        }

        watchRepo.save(watch);
        return "redirect:/admin/pets";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        watchRepo.deleteById(id);
        return "redirect:/admin/pets";
    }

    @GetMapping("/image/{id}")
    @ResponseBody      // returned raw object directly to the HTTP response body not the template.
    public byte[] getImage(@PathVariable Long id) {
        Watch watch = watchRepo.findById(id).orElseThrow();
        return watch.getwatchImage();
    }
}

