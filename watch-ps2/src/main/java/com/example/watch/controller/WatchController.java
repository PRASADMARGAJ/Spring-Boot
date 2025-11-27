package com.example.watch.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.watch.model.Watch;
import com.example.watch.model.enums.Catgeries;
import com.example.watch.repository.WatchRepository;



@Controller
@RequestMapping("/admin/watch")
public class WatchController {
     private final WatchRepository  watchRepository;

    public WatchController(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @GetMapping
    public String viewWatch(Model model) {
        model.addAttribute("watch", watchRepository.findAll());
        return "admin/Watch/view_watch";
    }

    @GetMapping("/add")
    public String addWatchForm(Model model) {
        model.addAttribute("watch", new Watch());
        model.addAttribute("catgeries", Catgeries.values());
        return "admin/watch/add_watch";
    }

    @PostMapping("/add")
    public String addWatch(@ModelAttribute Watch watch,
                         @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            watch.setwatchImages(imageFile.getBytes());
        }

        watchRepository.save(watch);
        return "redirect:/admin/watch";
    }

    @GetMapping("/update/{id}")
    public String updateWatchForm(@PathVariable Long id, Model model) {
        Watch watch = watchRepository.findById(id).orElse(new Watch());
        model.addAttribute("watch", watch);
        model.addAttribute("categories", Catgeries.values());
        return "admin/watch/update_watch";
    }

    @PostMapping("/update")
    public String updateWatch(@ModelAttribute Watch watch,
                            @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!imageFile.isEmpty()) {
            watch.setwatchImages(imageFile.getBytes());
        }

        watchRepository.save(watch);
        return "redirect:/admin/watch";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        watchRepository.deleteById(id);
        return "redirect:/admin/watch";
    }

    @GetMapping("/image/{id}")
    @ResponseBody      // returned raw object directly to the HTTP response body not the template.
    public byte[] getImage(@PathVariable Long id) {
        Watch watch = watchRepository.findById(id).orElseThrow();
        return watch.getwatchImages();
    }
}
