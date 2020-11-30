package com.example.courserequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course/request")
public class CourseRequestController {
    private final Producer producer;
    private CourseInfoService courseInfoService;

    @Autowired
    public CourseRequestController(Producer producer, CourseInfoService courseInfoService) {
        this.producer = producer;
        this.courseInfoService = courseInfoService;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") Long userId,
                                           @RequestParam("courseId") Long courseId) {

        CourseRequest courseRequest = new CourseRequest(userId, courseInfoService.getCourseById(courseId));
        this.producer.bookRequestNotify(courseRequest);
        return "Your request sent successful!";
    }
}
