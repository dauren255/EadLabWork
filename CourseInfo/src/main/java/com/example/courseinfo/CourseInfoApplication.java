package com.example.courseinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseInfoApplication.class, args);
    }

}
