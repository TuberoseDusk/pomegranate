package com.pomegranate.common.exception;

import com.pomegranate.common.enums.ResponseEnum;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final ResponseEnum responseEnum;

    public BusinessException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg(), null, false, false);
        this.responseEnum = responseEnum;
    }
}
