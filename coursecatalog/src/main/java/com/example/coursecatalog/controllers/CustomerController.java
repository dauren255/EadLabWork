package com.example.coursecatalog.controllers;

import com.example.coursecatalog.models.Course;
import com.example.coursecatalog.models.CourseCatalog;
import com.example.coursecatalog.models.Rating;
import com.example.coursecatalog.models.User;
import com.example.coursecatalog.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerInfoService customerInfoService;

    @GetMapping("/users")
    public String getAllUsers(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<User> users;
        if (filter != null && !filter.isEmpty()) {
            users = customerInfoService.getAllUsersByUsername(filter);
        } else {
            users = customerInfoService.getAllUsers();
        }
        model.addAttribute("users", users);
        model.addAttribute("filter", filter);
        return "users";
    }

    @GetMapping("/users/{id}")
    public User getUsersById(@PathVariable Long id) {
        return customerInfoService.getUserById(id);
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("text", "");
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password , Model model) {

        model.addAttribute("text", customerInfoService.login(username, password));
        return "login";
    }
}
