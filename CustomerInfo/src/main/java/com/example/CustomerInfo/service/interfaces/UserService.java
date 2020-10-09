package com.example.CustomerInfo.service.interfaces;

import com.example.CustomerInfo.models.User;
import com.example.CustomerInfo.models.UserD;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Iterable<User> findAll();
    User findById(Long id);
    void save(User user);
    UserD findByIdD(Long id);
    void deleteById(Long id);
}
