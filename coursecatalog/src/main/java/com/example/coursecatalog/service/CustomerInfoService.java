package com.example.coursecatalog.service;

import com.example.coursecatalog.models.User;
import com.example.coursecatalog.service.interfaces.CustomerInfoServiceInt;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
public class CustomerInfoService implements CustomerInfoServiceInt {
    @Autowired
    RestTemplate restTemplate;

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("UTF-8")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }

    @Transactional
    public User getUserById(Long id) {
        return restTemplate.getForObject
                ("http://customer-info-service/userString/" + id,
                        User.class);
    }


}
