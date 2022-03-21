package com.bekzodkeldiyarov.springpetproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @GetMapping({"", "/", "/index"})
    public String ownersIndex() {
        return "owners/index";
    }
}
