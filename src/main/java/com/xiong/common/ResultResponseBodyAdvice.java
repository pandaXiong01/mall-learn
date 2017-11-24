package com.xiong.common;

import com.xiong.common.exceptions.ValidationException;
import com.mysql.jdbc.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 有个问题当controller返回String类型时会抛出异常，java.lang.ClassCastException: com.xiong.common.ResultResponseBodyAdvice$Result cannot be cast to java.lang.String
 * 目前未知原因
 * ResponseBodyAdvice<Object> 指定泛型类型
 * Created by gonghui on 2017/11/6.
 */
@ControllerAdvice(basePackages = "com.xiong")
public class ResultResponseBodyAdvice implements ResponseBodyAdvice<Object>{



    private final static int successCode=1;//成功编码
    private final static int errorCode=0;//验证错误 (定义一个验证异常，验证失败抛异常，比如参数错误，主要验证前端参数)
    private final static int sysErrorCode=-1;//系统错误
    private final static String DefaultMsg="网络不给力，请稍后再试";


    @Override
    /**
     * 过滤是否是json的数据
     */
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        Boolean isRest = AnnotationUtils.isAnnotationDeclaredLocally(
                RestController.class, methodParameter.getContainingClass());
        ResponseBody responseBody = AnnotationUtils.findAnnotation(
                methodParameter.getMethod(), ResponseBody.class);
        if (isRest || responseBody != null) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean supports(MethodParameter methodParameter, Class aClass) {
//
//        Boolean isRest = AnnotationUtils.isAnnotationDeclaredLocally(
//                RestController.class, methodParameter.getContainingClass());
//        ResponseBody responseBody = AnnotationUtils.findAnnotation(
//                methodParameter.getMethod(), ResponseBody.class); //得到方法上的注解
//        if (isRest || responseBody != null) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }

    /**
     * 修改返回的数据
     */
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        if (o instanceof Result) {
//            return o;
//        }
//        Result result = Result.getInstance();
//        o = o==null?"":o;
//        result.setResult(o);
//        return result;
//
//    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,

                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (!(o instanceof Result)) {
            Result result = Result.getInstance();
            o=o==null?"":o;
            result.setResult(o);
            o = result;
        }
        return o;
    }



    /**
     * 全局异常的处理
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Result handleAllException(HttpServletRequest request, Exception ex) {

        ex.printStackTrace();
        String msg = DefaultMsg;
        Integer code = errorCode;
        if (ex instanceof ValidationException) {
            ValidationException validationException = (ValidationException)ex;
            if (validationException.getCode() != null) {
                code = validationException.getCode();
            }
            if (!StringUtils.isNullOrEmpty(validationException.getMessage())) {
                msg = validationException.getMessage();
            }
        }
        Result response = new Result();
        response.setSuccess(false);
        response.setResult("");
        response.setCode(code);
        response.setMsg(msg);
        return response;

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

        public static Result getInstance() {
            Result result = new Result();
            result.setSuccess(true);
            result.setMsg("操作成功");
            result.setResult("");
            result.setCode(successCode);
            return result;
        }
    }
}



