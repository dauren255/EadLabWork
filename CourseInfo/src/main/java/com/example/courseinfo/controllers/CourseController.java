package com.example.courseinfo.controllers;

import com.example.courseinfo.models.Course;
import com.example.courseinfo.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
    @Autowired
    private CourseServiceImpl courseServiceImpl;
    @GetMapping("/courses")
    public Iterable<Course> allCourses() {
        Iterable<Course> courses;
        courses = courseServiceImpl.findAll();
        return courses;
    }
    @GetMapping("/courses/{title}")
    public Iterable<Course> allCoursesByTitle(@PathVariable String title) {
        Iterable<Course> courses;
        courses = courseServiceImpl.findAllByTitleContainingIgnoreCase(title);
        return courses;
    }
    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        Course course;
        course = courseServiceImpl.findById(id);
        return course;
    }

    @PostMapping("/addCourse")
    public void addBlog(@RequestBody Course course) {
        courseServiceImpl.save(course);
    }
}
