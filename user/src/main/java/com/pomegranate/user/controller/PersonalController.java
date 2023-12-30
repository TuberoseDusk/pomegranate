package com.pomegranate.user.controller;

import com.pomegranate.common.response.Response;
import com.pomegranate.user.response.UserCardRes;
import com.pomegranate.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    @Resource
    private UserService userService;

    @GetMapping("/userCard")
    public Response<UserCardRes> userCard() {
        return Response.success(userService.queryUserCard());
    }

}
