package com.example.coursecatalog.service;

import com.example.coursecatalog.models.User;
import com.example.coursecatalog.service.interfaces.CustomerInfoServiceInt;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerInfoService implements CustomerInfoServiceInt {
    @Autowired
    RestTemplate restTemplate;
    @Transactional
    public User getUserById(Long id) {
//        return restTemplate.getForObject
//                ("http://customer-info-service/user/" + id,
//                        User.class);
        String apiCredentials = "admin:admin";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


//        return restTemplate.getForObject(
//                "http://book-info-service/book/info/" + userId,
//                UserBook.class);
        return restTemplate.exchange("http://customer-info-service/user/" + id,
                HttpMethod.GET, entity, User.class).getBody();
    }

    @Transactional
    public User getUserByIdFallback(Long id) {
        User userBook = new User(-1L, "Not available", "Not available");
        return userBook;
    }
    @Transactional
    public List<User> getAllUsers() {
        User [] users = restTemplate.getForObject("http://customer-info-service/users",
                User[].class);
        return Arrays.asList(users);
    }

    @Transactional
    public List<User> allUsersByUsername(String filter) {
        User [] users = restTemplate.getForObject("http://customer-info-service/users",
                User[].class);
        return Arrays.asList(users);
    }

    @Transactional
    public User getUserByUsername(String username) {
        return restTemplate.getForObject("http://customer-info-service/userByUsername/" + username, User.class);
    }
}
