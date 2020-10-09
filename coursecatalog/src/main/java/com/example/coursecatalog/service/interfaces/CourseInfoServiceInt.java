package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseInfoServiceInt {
    ResponseEntity<?> courseById(Long id);
    List<Course> allCourse();
    List<Course> allCourseByTitle(String title);
    void addCourse(Course course);
}
