package com.example.courserating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseRatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseRatingApplication.class, args);
    }

}
