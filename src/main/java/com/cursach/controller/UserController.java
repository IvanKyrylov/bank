package com.cursach.controller;

import com.cursach.entity.User;
import com.cursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String allUser(Model model) {
        model.addAttribute("userList", userService.allUser());
        return "user";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, User user) {
        if(userService.add(user)) {
            return "redirect:/login";
        }
        else {
           return registration(model.addAttribute("message", "No"));
        }
    }
}
