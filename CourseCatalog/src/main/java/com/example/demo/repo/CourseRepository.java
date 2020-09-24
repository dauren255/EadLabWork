package com.example.demo.repo;

import com.example.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Iterable<Course> findAllByTitle(String title);
}
