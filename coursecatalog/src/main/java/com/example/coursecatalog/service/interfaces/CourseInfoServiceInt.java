package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.Course;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public interface CourseInfoServiceInt {
    ResponseEntity<?> courseById(Long id);
    Course courseByIdFallback(Long id);
    void addCourse(Course course);
    List<Course> allCourse();
    List<Course> allCourseFallback();
    List<Course> allCourseByTitle(String title);
    List<Course> allCourseByTitleFallback(String title);
}
