package com.example.first_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.first_project.model.Cart;
import com.example.first_project.model.Watch;
import com.example.first_project.repository.CartRepo;
import com.example.first_project.repository.WatchRepo;
import com.example.first_project.repository.UserRepo;


@Controller
@RequestMapping("/cart")
public class CartController {
      private final CartRepo cartRepo;
    private final UserRepo userRepo;
    private final WatchRepo watchRepo;

    public CartController(CartRepo cartRepo, UserRepo userRepo, WatchRepo watchRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
        this.watchRepo = watchRepo;
    }

    @GetMapping
    public String listCart(Model model) {
        model.addAttribute("cartItems", cartRepo.findAll());
        return "cart/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("cart", new Cart());
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("pets", watchRepo.findAll());
        return "cart/add";
    }

    @PostMapping("/add")
    public String addCart(@ModelAttribute Cart cart) {
        cartRepo.save(cart);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        cartRepo.deleteById(id);
        return "redirect:/cart";
    }
}

