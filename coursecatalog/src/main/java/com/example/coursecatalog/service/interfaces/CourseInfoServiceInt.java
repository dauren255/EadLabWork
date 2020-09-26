package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseInfoServiceInt {
    Course courseById(Long id);
}
