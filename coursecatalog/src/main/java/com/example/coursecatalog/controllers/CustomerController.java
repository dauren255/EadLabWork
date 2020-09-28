package com.example.coursecatalog.controllers;

import com.example.coursecatalog.models.User;
import com.example.coursecatalog.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    CustomerInfoService customerInfoService;

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id) {
        return customerInfoService.userById(id).toString();
    }
}
