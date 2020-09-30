package com.example.coursecatalog.service;

import com.example.coursecatalog.models.Course;
import com.example.coursecatalog.service.interfaces.CourseInfoServiceInt;
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
                "http://course-info-service/course/" + id, Course.class);
    }

}
