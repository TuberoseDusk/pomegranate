package com.pomegranate.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;

    private String name;
    private String password;
    private String email;

    private Integer gender;
    private String profile;
    private String sign;
    private String location;
}
