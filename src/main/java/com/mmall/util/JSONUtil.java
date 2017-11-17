package com.mmall.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by gonghui on 2017/11/17.
 */
public class JSONUtil {


    public static String toJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = "";
        try {
            jsonResult = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
}
