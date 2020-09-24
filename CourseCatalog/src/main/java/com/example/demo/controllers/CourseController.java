package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
    @GetMapping("/courses")
    public Iterable<Course> allCourses() {
        Iterable<Course> courses;
        courses = courseService.findAll();
        return courses;
    }
    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        Course course;
        course = courseService.findById(id);
        return course;
    }

    @PostMapping("/addCourse")
    public void addBlog(@RequestBody Course course) {
        courseService.save(course);
    }
}
