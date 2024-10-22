package com.example.Validator.jsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }
}