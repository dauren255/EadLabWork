package com.example.demo.service;

import com.example.demo.models.CourseRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseRatingService {
    @Autowired
    RestTemplate restTemplate;

    public CourseRating courseRatingByBookId(Long id){
        return restTemplate.getForObject(
                "http://localhost:8082/rating/" + id, CourseRating.class);
    }

    public CourseRating courseRatingByBookIdFallback(Long bookId) {
        return new CourseRating(bookId, 0);
    }
}
