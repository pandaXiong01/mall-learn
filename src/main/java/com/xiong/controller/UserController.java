package com.xiong.controller;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.xiong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by gonghui on 2017/11/3.
 */
@Controller
@RequestMapping("xiong/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @RequestMapping("login")
    public ServerResponse<User> login(String name, String password, HttpSession session) {
        ServerResponse<User> serverResponse = userService.login(name, password);
        if (serverResponse.isSuccess()) {
        }


        return serverResponse;
    }
}
