package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.service.interfaces.CourseInfoServiceInt;
import com.example.demo.service.interfaces.CustomerInfoServiceInt;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
@Service
public class CustomerInfoService implements CustomerInfoServiceInt {
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public User userById(Long id){
        String apiCredentials = "admin:admin";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


//        return restTemplate.getForObject(
//                "http://book-info-service/book/info/" + userId,
//                UserBook.class);
        return restTemplate.exchange("http://localhost:8081/user/" + id,
                HttpMethod.GET, entity, User.class).getBody();
//        return restTemplate.getForObject(
//                "http://localhost:8082/rating/" + id, CourseRating.class);
    }
}
