package com.example.experiment2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.experiment2.model.User;
import com.example.experiment2.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
         model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/authenticate")
    public String loginUser(@ModelAttribute User user, Model model) {
        if(userService.authenticateUser(user.getName(), user.getPassword())) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error","Invalid Username and Password");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }

}
