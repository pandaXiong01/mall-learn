package com.mmall.common.exceptions;

/**
 * Created by gonghui on 2017/11/17.
 */
public class ValidationException extends RuntimeException {

    private Integer code;
    public ValidationException(String msg, Integer code, Throwable throwable) {
        super(msg, throwable);
        this.code = code;
    }

    public ValidationException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ValidationException(String message) {
        super(message);
    }

    public Integer getCode() {
        return this.code;
    }

}
