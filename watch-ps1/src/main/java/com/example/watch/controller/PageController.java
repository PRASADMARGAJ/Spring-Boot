package com.example.watch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/AddToCart")
    public String AddToCart() {
        return "AddToCart";
    }

    @GetMapping("/Collection")
    public String Collection() {
        return "Collection";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/ReturnPolicy")
    public String ReturnPolicy() {
        return "ReturnPolicy";
    }

    @GetMapping("/DeliveryShipping")
    public String DeliveryShipping() {
        return "DeliveryShipping";
    }

    @GetMapping("/PrivacyPolicy")
    public String PrivacyPolicy() {
        return "PrivacyPolicy";
    }

    @GetMapping("/TermsofService")
    public String TermsofService() {
        return "TermsofService";
    }

    @GetMapping("/Blogs")
    public String Blogs() {
        return "Blogs";
    }

    @GetMapping("/RefundPolicy")
    public String RefundPolicy() {
        return "RefundPolicy";
    }

    @GetMapping("/FAQs")
    public String FAQs() {
        return "FAQs";
    }

    @GetMapping("/OurBoutiques")
    public String OurBoutiques() {
        return "OurBoutiques";
    }

    @GetMapping("/watchlist")
    public String watchlist() {
        return "watchlist";
    }
}
