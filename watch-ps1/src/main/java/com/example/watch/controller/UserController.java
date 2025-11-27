package com.example.watch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.watch.model.User;
import com.example.watch.repository.UserRepository;

@Controller
@RequestMapping("/index/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Display all users
    @GetMapping
    public String viewUsers(Model model) {
        model.addAttribute("users", userRepository.findAll()); // List of all users
        return "index/user/view_user";
    }

    // Show form to add a new user
    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User()); // Add an empty user object for the form
        return "index/user/add_user";
    }

    // Handle form submission for adding a new user
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user); // Save the new user
        return "redirect:/index/users";
    }

    // Show form to update an existing user
    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElse(new User());
        model.addAttribute("user", user);
        return "index/user/update_user"; // Show the update form
    }

    // Handle form submission for updating an existing user
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userRepository.save(user); // Save the updated user
        return "redirect:/index/users";
    }

    // Delete a user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id); // Delete user by ID
        return "redirect:/index/users";
    }
}
