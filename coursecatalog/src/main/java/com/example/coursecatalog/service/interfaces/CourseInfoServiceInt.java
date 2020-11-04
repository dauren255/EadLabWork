package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseInfoServiceInt {
    ResponseEntity<?> courseById(Long id) throws InterruptedException;
    Course courseByIdFallback(Long id);
    void addCourse(Course course);
    List<Course> allCourse() throws InterruptedException;
    List<Course> allCourseFallback();
    List<Course> allCourseByTitle(String title);
    List<Course> allCourseByTitleFallback(String title);
}
