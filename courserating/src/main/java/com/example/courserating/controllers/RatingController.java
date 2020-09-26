package com.example.courserating.controllers;

import com.example.courserating.models.Rating;
import com.example.courserating.service.RatingImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {
    @Autowired
    RatingImplService ratingService;

    @GetMapping("/ratings")
    public Iterable<Rating> allCourses() {
        Iterable<Rating> ratings;
        ratings = ratingService.findAll();
        return ratings;
    }
    @GetMapping("/rating/{bookid}")
    public Rating getCourseById(@PathVariable Long bookid) {
        Rating rating;
        rating = ratingService.findByBookId(bookid);
        return rating;
    }

    @PostMapping("/addRating")
    public void addBlog(@RequestBody Rating rating) {
        ratingService.save(rating);
    }

    @PostMapping("/deleteRating/{bookid}")
    public void addBlog(@PathVariable Long bookid) {
        ratingService.deleteById(bookid);
    }
}
