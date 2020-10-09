package com.example.coursecatalog.controllers;

import com.example.coursecatalog.models.Rating;
import com.example.coursecatalog.service.CourseRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RatingController {
    @Autowired
    CourseRatingService courseRatingService;

    @GetMapping("/rating/{courseId}")
    public Rating getRating(@PathVariable Long courseId) {
        return courseRatingService.courseRatingByCourseId(courseId);
    }

}
