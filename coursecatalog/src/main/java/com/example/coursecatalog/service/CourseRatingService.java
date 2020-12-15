package com.example.coursecatalog.service;

import com.example.coursecatalog.models.Rating;
import com.example.coursecatalog.service.interfaces.CourseRatingServiceInt;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseRatingService implements CourseRatingServiceInt {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "courseRatingByCourseIdFallback",
            threadPoolKey = "courseRatingByCourseId",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
//                    @HystrixProperty(name = "maximumSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
//                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true")

            })
    public Rating courseRatingByCourseId(Long id) {
        return restTemplate.getForObject(
                "http://course-rating-service/rating/" + id, Rating.class);
    }

    public Rating courseRatingByCourseIdFallback(Long id) {
        return new Rating((long) 0, id, 0);
    }

    public void addRating(Rating rating) {
        restTemplate.postForObject("http://course-rating-service/addRating", rating, Rating.class);
    }

}
