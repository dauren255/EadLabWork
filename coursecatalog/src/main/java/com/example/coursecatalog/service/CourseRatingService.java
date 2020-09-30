package com.example.coursecatalog.service;

import com.example.coursecatalog.models.Rating;
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
    public Rating courseRatingByCourseId(Long id){
        return restTemplate.getForObject(
                "http://course-rating-service/rating/" + id, Rating.class);
    }

    @Transactional
    public Rating courseRatingByCourseIdFallback(Long courseid) {
        return new Rating((long) 0, courseid, 0);
    }
}
