package com.example.notifyservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    @KafkaListener(topics = "book_requests", groupId = "group_id")
    public void consume(CourseRequest courseRequest) throws IOException {
        System.out.println(String.format("#### -> Notify user by email: -> %s",
                "User " + courseRequest.getUserId() + " purchased course "
                        + courseRequest.getCourse().toString()));
    }
}
