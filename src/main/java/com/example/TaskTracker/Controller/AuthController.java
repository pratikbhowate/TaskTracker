package com.example.TaskTracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.TaskTracker.pojo.Users;
import com.example.TaskTracker.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";  
    }

    @GetMapping("/register")
    public String register() {
        return "register"; 
    }

    @PostMapping("/register")
    public String processRegistration(Users users) {
        userRepository.save(users);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(Users users, Model model) {
        Users existingUser = userRepository.findByUsername(users.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(users.getPassword())) {
            return "redirect:/tasks/"; 
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; 
        }
    }
}
