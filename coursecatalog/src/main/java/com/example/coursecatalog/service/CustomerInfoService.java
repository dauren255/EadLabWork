package com.example.coursecatalog.service;

import com.example.coursecatalog.models.User;
import com.example.coursecatalog.service.interfaces.CustomerInfoServiceInt;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerInfoService implements CustomerInfoServiceInt {
    @Autowired
    RestTemplate restTemplate;
    String apiCredentials = "rest-client:p@ssword";
    String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

    @Transactional
    @HystrixCommand(fallbackMethod = "getUserByIdFallback",
            threadPoolKey = "getUserById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
//                    @HystrixProperty(name = "maximumSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
//                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true")

            })
    public User getUserById(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://customer-info-service/user/" + id,
                HttpMethod.GET, entity, User.class).getBody();
    }

    @Transactional
    public User getUserByIdFallback(Long id) {
        User user = new User(-1L, "Not available", "Not available");
        return user;
    }

    @Transactional
    @HystrixCommand(fallbackMethod = "getAllUsersFallback",
            threadPoolKey = "getAllUsers",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
//                    @HystrixProperty(name = "maximumSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
//                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true")

            })
    public List<User> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        User [] users = restTemplate.exchange("http://customer-info-service/users",
                HttpMethod.GET, entity, User[].class).getBody();
        return Arrays.asList(users);
    }

    @Transactional
    public List<User> getAllUsersFallback() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(-1L, "Not available", "Not available"));
        return users;
    }

    @Transactional
    @HystrixCommand(fallbackMethod = "getAllUsersByUsernameFallback",
            threadPoolKey = "getAllUsersByUsername",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
//                    @HystrixProperty(name = "maximumSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
//                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true")

            })
    public List<User> getAllUsersByUsername(String filter) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        User [] users = restTemplate.exchange("http://customer-info-service/usersByUsername/" + filter,
                HttpMethod.GET, entity, User[].class).getBody();
        return Arrays.asList(users);
    }

    @Transactional
    public List<User> getAllUsersByUsernameFallback(String filter) {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(-1L, "Not available", "Not available"));
        return users;
    }

    @Transactional
    @HystrixCommand(fallbackMethod = "getUserByUsernameFallback",
            threadPoolKey = "getUserByUsername",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
//                    @HystrixProperty(name = "maximumSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
//                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true")

            })
    public User getUserByUsername(String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://customer-info-service/userByUsername/" + username ,
                HttpMethod.GET, entity, User.class).getBody();
    }

    @Transactional
    public User getUserByUsernameFallback(String username) {
        User user = new User(-1L, "Not available", "Not available");
        return user;
    }

    @Transactional
    public String login(String username, String password) {
        String apiCredentials = username+":"+password;
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        User user = restTemplate.exchange("http://customer-info-service/users",
                HttpMethod.GET, entity, User.class).getBody();
        if(user != null ){
            return "All ok";
        }
        return "All not ok";
    }
}
