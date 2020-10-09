package com.example.coursecatalog.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCatalog {
    private Long id;
    private String title;
    private String author;
    private int rating;
}
