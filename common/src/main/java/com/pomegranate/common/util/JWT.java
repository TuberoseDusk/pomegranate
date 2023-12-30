package com.pomegranate.common.util;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWT {
    private static final String key = "pomegranate";

    public static String encode(Long userId) {
        DateTime now = DateTime.now();
        DateTime expire = now.offsetNew(DateField.MONTH, 6);
        Map<String, Object> payload = new HashMap<>();
        payload.put(JWTPayload.ISSUED_AT, now);
        payload.put(JWTPayload.EXPIRES_AT, expire);
        payload.put(JWTPayload.NOT_BEFORE, now);

        payload.put("userId", userId);

        String token = JWTUtil.createToken(payload, key.getBytes());
        log.info("create token: {}", token);
        return token;
    }

    public static Long decode(String token) {
        if (token == null || token.trim().isEmpty()) {
            return null;
        }
        cn.hutool.jwt.JWT jwt = JWTUtil.parseToken(token).setKey(key.getBytes());
        JSONObject payloads = jwt.getPayloads();
        return ((NumberWithFormat)payloads.get("userId")).longValue();
    }
}
