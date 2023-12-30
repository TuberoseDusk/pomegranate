package com.pomegranate.user.controller;

import com.pomegranate.common.response.Response;
import com.pomegranate.user.request.UserLoginReq;
import com.pomegranate.user.request.UserRegisterReq;
import com.pomegranate.user.response.UserLoginRes;
import com.pomegranate.user.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Response<UserLoginRes> login(@Valid @RequestBody UserLoginReq userLoginReq) {
        return Response.success(userService.login(userLoginReq));
    }
}
