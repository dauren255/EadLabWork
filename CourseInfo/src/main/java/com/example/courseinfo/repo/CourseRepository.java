package com.example.courseinfo.repo;

import com.example.courseinfo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Iterable<Course> findAllByTitle(String title);
}
