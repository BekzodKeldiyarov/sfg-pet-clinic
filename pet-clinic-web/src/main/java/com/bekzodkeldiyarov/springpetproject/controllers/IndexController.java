package com.bekzodkeldiyarov.springpetproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "", "index", "index.html"})
    public String index() {
        System.out.println("Test");
        return "index";
    }
}
