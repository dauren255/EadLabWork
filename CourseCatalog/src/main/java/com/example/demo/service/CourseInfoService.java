package com.example.demo.service;


import com.example.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseInfoService {

    @Autowired
    RestTemplate restTemplate;

    public Course courseById(Long id){
        return restTemplate.getForObject(
                "http://localhost:8080/course/" + id, Course.class);
    }

}
