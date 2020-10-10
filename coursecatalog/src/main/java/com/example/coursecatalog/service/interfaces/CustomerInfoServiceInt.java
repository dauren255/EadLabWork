package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerInfoServiceInt {
    User getUserById(Long id);
    List<User> allUsersByUsername(String filter);
}
