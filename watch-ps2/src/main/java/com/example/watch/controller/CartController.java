package com.example.watch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.watch.model.Cart;
import com.example.watch.repository.CartRepository;
import com.example.watch.repository.UserRepository;
import com.example.watch.repository.WatchRepository;

@Controller
@RequestMapping("/admin/cart")
public class CartController {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final WatchRepository watchRepository;

    public CartController(CartRepository cartRepository,
            UserRepository userRepository,
            WatchRepository watchRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.watchRepository = watchRepository;
    }

    @GetMapping
    public String listCart(Model model) {
        model.addAttribute("cartItems", cartRepository.findAll());
        return "/admin/cart/view_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cart", new Cart());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("watchs", watchRepository.findAll());
        return "/admin/cart/add_list";
    }

    @PostMapping("/add")
    public String addCart(@ModelAttribute Cart cart) {
        cartRepository.save(cart);
        return "redirect:/admin/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        cartRepository.deleteById(id);
        return "redirect:/admin/cart";
    }
}
