package com.pomegranate.common.interceptor;

import com.pomegranate.common.context.UserHolder;
import com.pomegranate.common.util.JWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Long userId = JWT.decode(token);
        UserHolder.setUserId(userId);
        log.info("user interceptor check user: {}", userId);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}