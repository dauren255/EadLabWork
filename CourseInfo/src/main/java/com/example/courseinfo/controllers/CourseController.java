package com.example.courseinfo.controllers;

import com.example.courseinfo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/courses")
    public Iterable<com.example.demo.models.Course> allCourses() {
        Iterable<com.example.demo.models.Course> courses;
        courses = courseService.findAll();
        return courses;
    }
    @GetMapping("/course/{id}")
    public com.example.demo.models.Course getCourseById(@PathVariable Long id) {
        com.example.demo.models.Course course;
        course = courseService.findById(id);
        return course;
    }

    @PostMapping("/addCourse")
    public void addBlog(@RequestBody com.example.demo.models.Course course) {
        courseService.save(course);
    }
}
