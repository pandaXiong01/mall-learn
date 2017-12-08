package com.xiong.controller;

import com.mmall.common.Const;
import com.mmall.pojo.User;
import com.xiong.common.exceptions.ValidationException;
import com.xiong.pojo.XUser;
import com.xiong.service.FileService;
import com.xiong.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gonghui on 2017/11/21.
 */
@Controller(value = "xiongUserController")
@RequestMapping("/xiong/user")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @RequestMapping("login")
    @ResponseBody
    public XUser login(String mobile, String password, HttpSession session) {

        XUser user = userService.login(mobile, password);
        session.setAttribute(Const.CURRENT_USER,user);
        session.setAttribute("string", new Date());
        return user;
    }

    @RequestMapping("loginOut")
    @ResponseBody
    public void loginOut(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);

    }

    @RequestMapping("register")
    @ResponseBody
    public void register(XUser user) {
        userService.register(user);
    }

    @RequestMapping("getUserInfo")
    @ResponseBody
    public XUser getUserInfo(HttpSession session) {

        XUser user = (XUser)session.getAttribute(Const.CURRENT_USER);
        return user;

    }

    @RequestMapping("updateUserInfo")
    @ResponseBody
    public void updateUserInfo(XUser newUser, HttpSession session) {
        XUser user = (XUser)session.getAttribute(Const.CURRENT_USER);

        if (user == null) {
            throw new ValidationException("用户未登录",-99);
        }

        newUser.setUserId(user.getUserId());
        userService.updateUserInfo(newUser);

    }

    @RequestMapping("upload_image")
    @ResponseBody
    public void uploadImage(MultipartFile file, HttpServletRequest request) {

        //  /Users/gonghui/Desktop/javaDemo/z12btf/target/mmall/upload
        String path = request.getSession().getServletContext().getRealPath("upload");
        String targetFileName = fileService.upload(file,path);
        if(StringUtils.isBlank(targetFileName)){
            //上传成功
            throw new ValidationException("上传失败");
        }


    }
}
