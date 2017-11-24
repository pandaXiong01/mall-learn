package com.xiong.util;

import com.xiong.common.exceptions.ValidationException;

/**
 * Created by gonghui on 2017/11/24.
 */
public class Check {
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new ValidationException(message);
        }
    }
    public static void isNull(Object object, String message,Integer code) {
        if (object == null) {
            throw new ValidationException(message,code);
        }
    }

    public static void isEmpty(String checkStr, String message) {
        if ((checkStr == null) || checkStr.isEmpty()) {
            throw new ValidationException(message);
        }

    }
    public static void isEmpty(String checkStr, String message,Integer code) {
        if ((checkStr == null) || checkStr.isEmpty()) {
            throw new ValidationException(message);
        }
    }

}
