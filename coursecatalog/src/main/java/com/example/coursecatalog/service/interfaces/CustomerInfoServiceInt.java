package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.User;
import org.springframework.stereotype.Service;

@Service
public interface CustomerInfoServiceInt {
    User userById(Long id);
}
