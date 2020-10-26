package com.example.coursecatalog.service;

import com.example.coursecatalog.models.Course;
import com.example.coursecatalog.service.interfaces.CourseInfoServiceInt;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseInfoService implements CourseInfoServiceInt {

    @Autowired
    RestTemplate restTemplate;

    @Transactional
    @HystrixCommand(fallbackMethod = "courseByIdFallback",
            threadPoolKey = "courseById")
    public ResponseEntity<?> courseById(Long id) {
        return ResponseEntity.ok(restTemplate.getForObject(
                "http://course-info-service/course/" + id, Course.class));
    }
    @Transactional
    public Course courseByIdFallback(Long id) {
        return new Course(-1L, "Not available", "Not available");
    }

    @Transactional
    public void addCourse(Course course) {
        restTemplate.postForObject("http://course-info-service/addCourse", course, Course.class);
    }

    @Transactional
    @HystrixCommand(fallbackMethod = "allCourseFallback",
                    threadPoolKey = "allCourse")
    public List<Course> allCourse() {
        Course[] courses = restTemplate.getForObject(
                "http://course-info-service/courses", Course[].class);
        return Arrays.asList(courses);
    }
    @Transactional
    public List<Course> allCourseFallback() {
        Course course = new Course();
        List<Course> list = new ArrayList<>();
        list.add(new Course(-1L, "Not available", "Not available"));
        return list;
    }

    @Transactional
    @HystrixCommand(fallbackMethod = "allCourseByTitleFallback",
            threadPoolKey = "allCourseByTitle")
    public List<Course> allCourseByTitle(String title) {
        Course[] courses = restTemplate.getForObject(
                "http://course-info-service/courses/" + title, Course[].class);
        return Arrays.asList(courses);
    }
    @Transactional
    public List<Course> allCourseByTitleFallback(String title) {
        Course course = new Course();
        List<Course> list = new ArrayList<>();
        list.add(new Course(-1L, "Not available", "Not available"));
        return list;
    }
}
