package com.example.courserating.service;

import com.example.courserating.models.Rating;
import com.example.courserating.repo.RatingRepository;
import com.example.courserating.service.interfaces.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RatingImplService implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Transactional
    public Iterable<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Transactional
    public Rating findByCourseId(Long id) {
        return ratingRepository.findAllByCourseId(id);
    }

    @Transactional
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    @Transactional
    public void deleteById(Long id) {
        ratingRepository.delete(ratingRepository.findAllByCourseId(id));
    }
}
