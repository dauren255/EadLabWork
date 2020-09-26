package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseRating {

    private Long bookid;
    private int rating;

    public CourseRating(Long bookid, int rating) {
        this.bookid = bookid;
        this.rating = rating;
    }
}
