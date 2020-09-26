package com.example.demo.service.interfaces;

import com.example.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface CustomerInfoServiceInt {
    User userById(Long id);
}
