package com.pomegranate.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterReq {

    @NotBlank(message = "请填写用户名")
    private String name;

    @NotBlank(message = "请填写密码")
    private String password;

    @NotBlank(message = "请填写邮箱")
    private String email;

}
