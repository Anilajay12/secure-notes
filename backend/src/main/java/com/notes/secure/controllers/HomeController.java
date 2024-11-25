package com.notes.secure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anil
 * @version 1.0
 * @since 11/22/2024
 */

@RestController
public class HomeController {

    @GetMapping("/api/hello")
    public String sayHello(){
        return "Hello, Thank you for your interest on visiting my application";
    }

    @GetMapping("/contact")
    public String fetchContactDetails(){
        return "+91 789 789 7896";
    }
}
