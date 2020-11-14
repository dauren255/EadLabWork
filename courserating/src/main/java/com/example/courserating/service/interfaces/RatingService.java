package com.example.courserating.service.interfaces;

import com.example.courserating.models.Rating;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {
    Iterable<Rating> findAll();

    Rating findByCourseId(Long id);

    void save(Rating rating);

    void deleteById(Long id);
}
