package com.example.demo.service.interfaces;

import com.example.demo.models.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Iterable<Course> findAll();
}
