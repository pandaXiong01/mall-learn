package com.xiong.controller;

import com.mmall.common.Const;
import com.mmall.pojo.User;
import com.xiong.common.exceptions.ValidationException;
import com.xiong.pojo.XUser;
import com.xiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("login")
    @ResponseBody
    public XUser login(String mobile, String password, HttpSession session) {

        XUser user = userService.login(mobile, password);
        session.setAttribute(Const.CURRENT_USER,user);
        session.setAttribute("string", new Date());
        return user;
    }

    @RequestMapping("register")
    @ResponseBody
    public void register(XUser user) {
        userService.register(user);
    }
}
