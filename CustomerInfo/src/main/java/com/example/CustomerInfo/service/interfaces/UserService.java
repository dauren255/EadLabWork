package com.example.CustomerInfo.service.interfaces;

import com.example.CustomerInfo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Iterable<User> findAll();
    User findById(Long id);
    void save(User user);
    void deleteById(Long id);
}
