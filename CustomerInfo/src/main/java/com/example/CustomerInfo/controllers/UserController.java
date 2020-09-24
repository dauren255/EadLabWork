package com.example.CustomerInfo.controllers;

import com.example.CustomerInfo.models.User;
import com.example.CustomerInfo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/users")
    public Iterable<User> allCourses() {
        Iterable<User> users;
        users = userService.findAll();
        return users;
    }
    @GetMapping("/user/{id}")
    public User getCourseById(@PathVariable Long id) {
        User user;
        user = userService.findById(id);
        return user;
    }

    @PostMapping("/addUser")
    public void addBlog(@RequestBody User user) {
        userService.save(user);
    }
}
