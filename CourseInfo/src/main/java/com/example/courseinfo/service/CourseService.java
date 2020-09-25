package com.example.courseinfo.service;
import com.example.demo.models.Course;
import com.example.courseinfo.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }
    @Transactional
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }
    @Transactional
    public Iterable<Course> findByTitle(String title) {
        return courseRepository.findAllByTitle(title);
    }
    @Transactional
    public void save(Course course) {
        courseRepository.save(course);
    }
    @Transactional
    public void deleteById(Long id) {
        courseRepository.delete(courseRepository.findById(id).get());
    }
}
