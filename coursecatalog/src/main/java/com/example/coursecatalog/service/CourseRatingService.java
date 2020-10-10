package com.example.coursecatalog.service;

import com.example.coursecatalog.models.Course;
import com.example.coursecatalog.models.Rating;
import com.example.coursecatalog.service.interfaces.CourseRatingServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseRatingService implements CourseRatingServiceInt {
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public Rating courseRatingByCourseId(Long id){
        return restTemplate.getForObject(
                "http://course-rating-service/rating/" + id, Rating.class);
    }

    @Transactional
    public void addRating(Rating rating) {
        restTemplate.postForObject("http://course-rating-service/addRating", rating, Rating.class);
//        restTemplate.put("http://course-rating-service/addRating", rating);
    }

    @Transactional
    public Rating courseRatingByCourseIdFallback(Long id) {
        return new Rating((long) 0, id, 0);
    }
}
