package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    CourseInfoService courseService;

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.courseById(id);
    }

}