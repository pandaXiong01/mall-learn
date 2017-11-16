package com.mmall.common;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 *
 * Created by gonghui on 2017/11/6.
 */
//@ControllerAdvice(basePackages = "com.mmall.controller")
public class ResultResponseBodyAdvice implements ResponseBodyAdvice{


    private final static int successCode=1;//成功编码
    private final static int errorCode=0;//验证错误 (定义一个验证异常，验证失败抛异常，比如参数错误，主要验证前端参数)
    private final static int sysErrorCode=-1;//系统错误
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        Boolean isRest = AnnotationUtils.isAnnotationDeclaredLocally(RestController.class, methodParameter.getContainingClass());
        ResponseBody responseBody = AnnotationUtils.findAnnotation(methodParameter.getMethod(),ResponseBody.class
        );
        if (isRest || responseBody != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return null;
    }

    public static class Result {
        private String msg;
        private Boolean success;
        private Object result;
        private Integer code;

        public String getMsg() {
            return msg;
        }

        public Boolean getSuccess() {
            return success;
        }

        public Object getResult() {
            return result;
        }

        public Integer getCode() {
            return code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public void setResult(Object result) {
            this.result = result;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }
}



