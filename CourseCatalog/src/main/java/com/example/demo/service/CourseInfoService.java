package com.example.demo.service;


import com.example.demo.models.Course;
import com.example.demo.service.interfaces.CourseInfoServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseInfoService implements CourseInfoServiceInt {

    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public Course courseById(Long id) {
        return restTemplate.getForObject(
                "http://localhost:8080/course/" + id, Course.class);
    }

}
