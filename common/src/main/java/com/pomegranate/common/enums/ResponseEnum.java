package com.pomegranate.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(-1, "未知错误");

    private final Integer code;
    private final String msg;
}
