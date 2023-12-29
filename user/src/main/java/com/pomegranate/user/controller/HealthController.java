package com.pomegranate.user.controller;

import com.pomegranate.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping("/hello")
    public Response<String> hello() {
        return Response.success("hello, user service.");
    }
}
