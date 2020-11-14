package com.example.CustomerInfo.service.interfaces;

import com.example.CustomerInfo.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Iterable<User> findAll();

    Iterable<User> findAllByUsername(String username);

    User findById(Long id);

    User findByUsername(String username);

    void save(User user);

    void deleteById(Long id);

    UserDetails loadUserByUsername(String s);
}
