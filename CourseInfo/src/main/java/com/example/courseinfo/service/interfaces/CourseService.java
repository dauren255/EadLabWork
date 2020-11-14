package com.example.courseinfo.service.interfaces;

import com.example.courseinfo.models.Course;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface CourseService {
    Iterable<Course> findAll();

    Iterable<Course> findAllByTitleContainingIgnoreCase(String filter);

    Course findById(Long id);

    void save(Course course);

    void deleteById(Long id);
}
