package com.example.api.Controlllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {

    @GetMapping("/book")

    public String getBoks() {
        return "Book details";
    }
    
}
