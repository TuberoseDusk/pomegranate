package com.pomegranate.user.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCardRes {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    private String name;
    private String email;

    private Integer gender;
    private String profile;
    private String sign;
    private String location;
}
