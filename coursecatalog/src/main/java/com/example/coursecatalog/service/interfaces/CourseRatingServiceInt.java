package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.CourseRating;
import org.springframework.stereotype.Service;

@Service
public interface CourseRatingServiceInt {
    CourseRating courseRatingByBookId(Long id);
}
