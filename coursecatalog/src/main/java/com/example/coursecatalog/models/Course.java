package com.example.coursecatalog.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long id;
    private String title;
    private String author;

    public Course(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
