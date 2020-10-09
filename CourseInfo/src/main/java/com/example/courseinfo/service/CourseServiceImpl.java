package com.example.courseinfo.service;
import com.example.courseinfo.models.Course;
import com.example.courseinfo.repo.CourseRepository;
import com.example.courseinfo.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public Iterable<Course> findAllByTitleContainingIgnoreCase(String filter) {
        return courseRepository.findAllByTitleContainingIgnoreCase(filter);
    }
    @Transactional
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }
    @Transactional
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
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
