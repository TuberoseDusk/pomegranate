package com.pomegranate.user.service;

import com.pomegranate.common.util.Snowflake;
import com.pomegranate.user.entity.User;
import com.pomegranate.user.enums.GenderEnum;
import com.pomegranate.user.mapper.UserMapper;
import com.pomegranate.user.request.UserRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     **/
    public void save(UserRegisterReq userRegisterReq) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterReq, user);

        user.setUserId(Snowflake.nextId());
        user.setGender(GenderEnum.UNKNOWN.getCode());
    }
}
