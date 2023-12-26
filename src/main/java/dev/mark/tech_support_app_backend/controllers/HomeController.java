package dev.mark.tech_support_app_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/")
    public String index() {
        
        return "Hello, human. The end is near.";
        
    }
    
}
