package com.example.demo.controllers;

import com.example.demo.models.CourseRating;
import com.example.demo.models.User;
import com.example.demo.service.CourseRatingService;
import com.example.demo.service.CustomerInfoService;
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
