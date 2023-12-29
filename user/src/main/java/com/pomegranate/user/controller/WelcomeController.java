package com.pomegranate.user.controller;

import com.pomegranate.common.response.Response;
import com.pomegranate.user.request.UserRegisterReq;
import com.pomegranate.user.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Response<Void> register(@Valid @RequestBody UserRegisterReq userRegisterReq) {
        userService.save(userRegisterReq);
        return Response.success();
    }
}
