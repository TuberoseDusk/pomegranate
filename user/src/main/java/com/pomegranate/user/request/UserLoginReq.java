package com.pomegranate.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginReq {
    @NotBlank(message = "请输入邮箱")
    private String email;
    @NotBlank(message = "请输入密码")
    private String password;
}
