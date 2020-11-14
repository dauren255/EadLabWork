package com.example.coursecatalog.service.interfaces;

import com.example.coursecatalog.models.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CourseRatingServiceInt {
    Rating courseRatingByCourseId(Long id);

    void addRating(Rating rating);

    Rating courseRatingByCourseIdFallback(Long id);
}
