package com.pomegranate.user.service;

import com.pomegranate.common.enums.ResponseEnum;
import com.pomegranate.common.exception.BusinessException;
import com.pomegranate.common.util.Snowflake;
import com.pomegranate.user.entity.User;
import com.pomegranate.user.enums.GenderEnum;
import com.pomegranate.user.mapper.UserMapper;
import com.pomegranate.user.request.UserLoginReq;
import com.pomegranate.user.request.UserRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     */
    public void save(UserRegisterReq userRegisterReq) {
        User user = userMapper.selectByEmail(userRegisterReq.getEmail());
        if (user != null) {
            throw new BusinessException(ResponseEnum.USER_EMAIL_EXIST);
        }

        user = new User();
        BeanUtils.copyProperties(userRegisterReq, user);

        user.setUserId(Snowflake.nextId());
        user.setName("YOU-KNOW-WHO");
        user.setPassword(DigestUtils.md5DigestAsHex(userRegisterReq.getPassword().getBytes()));
        user.setGender(GenderEnum.UNKNOWN.getCode());
    }

    /**
     * 用户登录
     */
    public void login(UserLoginReq userLoginReq) {
        User user = userMapper.selectByEmail(userLoginReq.getEmail());
        if (user == null) {
            throw new BusinessException(ResponseEnum.USER_NOT_EXIST);
        }

        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(userLoginReq.getPassword().getBytes()))) {
            throw new BusinessException(ResponseEnum.USER_PASSWORD_ERROR);
        }
    }
}
