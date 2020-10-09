package com.example.CustomerInfo.models;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserD {
    private Long id;

    private String username;
    private String password;
}
