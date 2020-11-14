package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public interface CustomerInfoServiceInt {
    User getUserById(Long id);

    User getUserByIdFallback(Long id);

    List<User> getAllUsers();

    List<User> getAllUsersFallback();

    List<User> getAllUsersByUsername(String filter);

    List<User> getAllUsersByUsernameFallback(String filter);

    User getUserByUsername(String username);

    User getUserByUsernameFallback(String username);
}
