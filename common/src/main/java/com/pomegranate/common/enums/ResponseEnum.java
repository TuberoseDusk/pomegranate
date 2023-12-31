package com.pomegranate.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    REQUEST_PARAM_ERROR(1, "输入参数错误"),
    UNKNOWN_ERROR(-1, "未知错误"),

    USER_NOT_EXIST(1001, "用户不存在"),
    USER_EMAIL_EXIST(1002, "邮箱已注册"),
    USER_PASSWORD_ERROR(1003, "密码错误"),
    USER_LOGIN_ERROR(1004, "用户登录信息错误");

    private final Integer code;
    private final String msg;
}
