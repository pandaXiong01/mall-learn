package com.xiong.common.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.xiong.pojo.XUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonghui on 2017/11/16.
 */
public class LoginInterceptor implements HandlerInterceptor {


    protected static final List<String> webRequestList = new ArrayList<>();

    static {
        webRequestList.add("page");
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Boolean loginValidation = true;
        XUser user = (XUser)httpServletRequest.getSession().getAttribute(Const.CURRENT_USER);
        if (user == null) {
            if (isWebRequest(httpServletRequest)) {

                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "user/login");
            } else  {
                ServerResponse response = ServerResponse.createByErrorMessage("用户未登录");
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonResult = objectMapper.writeValueAsString(response);
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json");
                PrintWriter writer = httpServletResponse.getWriter();
                writer.write(jsonResult);
            }
            loginValidation = false;
        }


        return loginValidation;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    protected Boolean isWebRequest(HttpServletRequest request) {
        Boolean isWeb = false;
        String uri = request.getRequestURI();
        String path = request.getContextPath();
        uri = uri.replaceFirst(path, "");
        if (uri.startsWith("/")) {
            uri = uri.replaceFirst("/", "");

        }
        for (String webRequest : webRequestList) {
            if (uri.startsWith(webRequest)) {
                return true;
            }
        }
        return isWeb;
    }


}
