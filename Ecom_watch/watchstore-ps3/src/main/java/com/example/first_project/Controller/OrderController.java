package com.example.first_project.Controller;
import com.example.first_project.model.Order;
import com.example.first_project.repository.OrderRepo;
import com.example.first_project.repository.WatchRepo;
import com.example.first_project.repository.AddressRepo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/orders")

public class OrderController {
    
     private final OrderRepo orderRepo;
    private final WatchRepo watchRepo;
    private final AddressRepo addressRepo;

    public OrderController(OrderRepo orderRepo, WatchRepo watchRepo, AddressRepo addressRepo) {
        this.orderRepo = orderRepo;
        this.watchRepo = watchRepo;
        this.addressRepo = addressRepo;
    }

    @GetMapping
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderRepo.findAll());  
        return "admin/order/view_order";  
    }

    @GetMapping("/add")
    public String addOrderForm(Model model) {
        model.addAttribute("order", new Order());  
        model.addAttribute("pets", watchRepo.findAll()); 
        model.addAttribute("addresses", addressRepo.findAll()); 
        return "admin/order/add_order";  
    }

    
    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        orderRepo.save(order);  // Save the new order
        return "redirect:/admin/orders"; 
    }

    @GetMapping("/update/{id}")
    public String updateOrderForm(@PathVariable Long id, Model model) {
        // Retrieve the order by ID, or create a new Order object if not found
        Order order = orderRepo.findById(id).orElse(new order());
        
        model.addAttribute("order", order);
        model.addAttribute("pets", watchRepo.findAll());  // Add all available pets
        model.addAttribute("addresses", addressRepo.findAll());  // Add all available addresses
        return "admin/order/update_order";  
    }

    @PostMapping("/update")
    public String updateOrder(@ModelAttribute Order order) {
        orderRepo.save(order);  
        return "redirect:/admin/orders";  
    }

    // Delete an order
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderRepo.deleteById(id);  
        return "redirect:/admin/orders";  
    }
}

