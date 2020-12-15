package com.example.courseinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"com.example.courseinfo.models" })
@EnableJpaRepositories(basePackages = {"com.example.courseinfo.repo"})
public class CourseInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseInfoApplication.class, args);
    }

}
