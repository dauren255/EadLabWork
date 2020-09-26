package com.example.coursecatalog.controllers;

import com.example.coursecatalog.models.Course;
import com.example.coursecatalog.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseInfoService courseInfoService;

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseInfoService.courseById(id);
    }

}