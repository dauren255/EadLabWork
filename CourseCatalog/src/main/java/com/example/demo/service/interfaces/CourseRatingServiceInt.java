package com.example.demo.service.interfaces;

import com.example.demo.models.CourseRating;
import org.springframework.stereotype.Service;

@Service
public interface CourseRatingServiceInt {
    CourseRating courseRatingByBookId(Long id);
}
