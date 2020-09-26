package com.example.coursecatalog.controllers;

import com.example.coursecatalog.models.CourseRating;
import com.example.coursecatalog.service.CourseRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RatingController {
    @Autowired
    CourseRatingService courseRatingService;

    @GetMapping("/rating/{id}")
    public CourseRating getRating(@PathVariable Long id) {
        return courseRatingService.courseRatingByBookId(id);
    }
}
