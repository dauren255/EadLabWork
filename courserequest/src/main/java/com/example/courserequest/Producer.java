package com.example.courserequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC = "book_requests";

    @Autowired
    private KafkaTemplate<String, CourseRequest> kafkaTemplate;

    public String bookRequestNotify(CourseRequest courseRequest) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", courseRequest));
        this.kafkaTemplate.send(TOPIC, courseRequest);
        return "Successfully";
    }
}
