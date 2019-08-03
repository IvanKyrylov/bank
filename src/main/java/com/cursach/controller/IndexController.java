package com.cursach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
//            model.addAttribute("message", "You are logged in as " + principal.getName());
            return "index";
    }
}
