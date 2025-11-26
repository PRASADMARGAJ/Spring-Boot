package com.example.watch.controller;

import com.example.watch.model.Order;
import com.example.watch.repository.OrderRepository;
import com.example.watch.repository.WatchRepository;
import com.example.watch.repository.UserRepository;
import com.example.watch.repository.AddressRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final WatchRepository watchRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public OrderController(OrderRepository orderRepository,
                           WatchRepository watchRepository,
                           AddressRepository addressRepository,
                           UserRepository userRepository) {

        this.orderRepository = orderRepository;
        this.watchRepository = watchRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "admin/order/view_order";
    }

    @GetMapping("/add")
    public String addOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("watch", watchRepository.findAll());
        model.addAttribute("addresses", addressRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "admin/order/add_order";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        orderRepository.save(order);
        return "redirect:/admin/orders";
    }

    @GetMapping("/update/{id}")
    public String updateOrderForm(@PathVariable Long id, Model model) {
        Order order = orderRepository.findById(id).orElse(new Order());
        model.addAttribute("order", order);
        model.addAttribute("watch", watchRepository.findAll());
        model.addAttribute("addresses", addressRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "admin/order/update_order";
    }

    @PostMapping("/update")
    public String updateOrder(@ModelAttribute Order order) {
        orderRepository.save(order);
        return "redirect:/admin/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "redirect:/admin/orders";
    }
}
