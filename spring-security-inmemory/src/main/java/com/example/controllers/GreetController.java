package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {
    @GetMapping("/greet")
    public String greetUser() {
        return "Have a great day";
    }

    @GetMapping("/products")
    public List<String> showProducts() {
        return Arrays.asList("Mobile","Laptop","KeyChain");
    }

    @GetMapping("/products/gadgets")
    public List<String> showGadgets() {
        return Arrays.asList("Mobile","Laptop");
    }

    @GetMapping("/admin/add-product")
    public String addProducts() {
        return "product added succesfully";
    }

    @GetMapping("/admin/update-product")
    public String updateProducts() {
        return "product updated succesfully";
    }
}
