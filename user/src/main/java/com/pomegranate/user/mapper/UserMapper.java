package com.pomegranate.user.mapper;

import com.pomegranate.user.entity.User;

public interface UserMapper {
    Integer insert(User user);

    Integer updateSelective(User user);

    User selectByUserId(Long userId);

    User selectByEmail(String email);
}
