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
    public Iterable<User> allUsers() {
        Iterable<User> users;
        users = userService.findAll();
        return users;
    }
    @GetMapping("/usersByUsername/{username}")
    public Iterable<User> getAllUserByUsername(@PathVariable String username) {
        Iterable<User> users;
        users = userService.findAllByUsername(username);
        return users;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        User user;
        user = userService.findById(id);
        return user;
    }
    @GetMapping("/userByUsername/{username}")
    public User getUserByUsername(@PathVariable String username) {
        User user;
        user = userService.findByUsername(username);
        return user;
    }

    @PostMapping("/addUser")
    public void addBlog(@RequestBody User user) {
        userService.save(user);
    }
}
