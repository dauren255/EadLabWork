package com.example.coursecatalog.controllers;

import com.example.coursecatalog.models.Course;
import com.example.coursecatalog.models.CourseCatalog;
import com.example.coursecatalog.models.Rating;
import com.example.coursecatalog.service.CourseInfoService;
import com.example.coursecatalog.service.CourseRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private CourseRatingService courseRatingService;

    @GetMapping("/home")
    public String homePage(@RequestParam(required = false, defaultValue = "") String filter, Model model) throws InterruptedException {
        List<CourseCatalog> courseCatalogs = new ArrayList<>();
        List<Course> courses;
        if (filter != null && !filter.isEmpty()) {
            courses = courseInfoService.allCourseByTitle(filter);
        } else {
            courses = courseInfoService.allCourse();
        }
        for (Course course : courses) {
            CourseCatalog courseCatalog = new CourseCatalog();
            courseCatalog.setId(course.getId());
            courseCatalog.setTitle(course.getTitle());
            courseCatalog.setAuthor(course.getAuthor());
            Rating rating = courseRatingService.courseRatingByCourseId(course.getId());
            courseCatalog.setRating(rating.getRating());
            courseCatalogs.add(courseCatalog);
        }
        model.addAttribute("courses", courseCatalogs);
        model.addAttribute("filter", filter);
        return "home";
    }

    @GetMapping("/addCourse")
    public String addBlog() {
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addBlog(@Valid CourseCatalog courseCatalog) throws InterruptedException {
        Course course = new Course();
        course.setTitle(courseCatalog.getTitle());
        course.setAuthor(courseCatalog.getAuthor());
        courseInfoService.addCourse(course);
        Thread.sleep(1000);
        Rating rating = new Rating();
        rating.setCourseId(3L);
        rating.setRating(courseCatalog.getRating());
        courseRatingService.addRating(rating);
        return "redirect:/home";
    }
}