package com.pomegranate.user.service;

import com.pomegranate.common.context.UserHolder;
import com.pomegranate.common.enums.ResponseEnum;
import com.pomegranate.common.exception.BusinessException;
import com.pomegranate.common.util.JWT;
import com.pomegranate.common.util.Snowflake;
import com.pomegranate.user.entity.User;
import com.pomegranate.user.enums.GenderEnum;
import com.pomegranate.user.mapper.UserMapper;
import com.pomegranate.user.request.UserLoginReq;
import com.pomegranate.user.request.UserRegisterReq;
import com.pomegranate.user.response.UserCardRes;
import com.pomegranate.user.response.UserLoginRes;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
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
        userMapper.insert(user);
        log.info("用户注册: {}", user.getUserId());
    }

    /**
     * 用户登录
     */
    public UserLoginRes login(UserLoginReq userLoginReq) {
        User user = userMapper.selectByEmail(userLoginReq.getEmail());
        if (user == null) {
            throw new BusinessException(ResponseEnum.USER_NOT_EXIST);
        }

        if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(userLoginReq.getPassword().getBytes()))) {
            throw new BusinessException(ResponseEnum.USER_PASSWORD_ERROR);
        }

        String token = JWT.encode(user.getUserId());
        log.info("用户登录： {}", user.getUserId());
        return new UserLoginRes(user.getUserId(), token);
    }

    /**
     * 查询用户信息
     */
    public UserCardRes queryUserCard() {
        Long userId = UserHolder.getUserId();
        User user = userMapper.selectByUserId(userId);
        if (user == null) {
            throw new BusinessException(ResponseEnum.USER_LOGIN_ERROR);
        }

        UserCardRes userCardRes = new UserCardRes();
        BeanUtils.copyProperties(user, userCardRes);
        log.info("查询用户信息： {}", user.getUserId());
        return userCardRes;
    }
}
