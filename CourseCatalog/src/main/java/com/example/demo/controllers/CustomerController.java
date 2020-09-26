package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.User;
import com.example.demo.service.CourseInfoService;
import com.example.demo.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerInfoService customerInfoService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return customerInfoService.userById(id);
    }
}
