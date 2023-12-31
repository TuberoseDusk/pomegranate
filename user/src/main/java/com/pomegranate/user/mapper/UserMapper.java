package com.pomegranate.user.mapper;

import com.pomegranate.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer insert(User user);

    Integer updateSelective(User user);

    User selectByUserId(Long userId);

    User selectByEmail(String email);
}
