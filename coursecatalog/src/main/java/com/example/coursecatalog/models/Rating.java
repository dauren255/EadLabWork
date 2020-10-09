package com.example.coursecatalog.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private Long id;
    private Long courseId;
    private int rating;

}
