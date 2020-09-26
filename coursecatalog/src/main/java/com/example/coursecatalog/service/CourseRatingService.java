package com.example.coursecatalog.service;

import com.example.coursecatalog.models.CourseRating;
import com.example.coursecatalog.service.interfaces.CourseRatingServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseRatingService implements CourseRatingServiceInt {
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public CourseRating courseRatingByBookId(Long id){
        return restTemplate.getForObject(
                "http://localhost:8082/rating/" + id, CourseRating.class);
    }

    @Transactional
    public CourseRating courseRatingByBookIdFallback(Long bookId) {
        return new CourseRating(bookId, 0);
    }
}
