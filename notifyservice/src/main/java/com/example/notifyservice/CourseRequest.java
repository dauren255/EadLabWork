package com.example.notifyservice;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private Long userId;
    private Course course;

}
