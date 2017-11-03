package com.xiong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by gonghui on 2017/11/3.
 */
@Controller
@RequestMapping("xiong/user")
public class UserController {
    @RequestMapping("login")
    public String login(String name, String password, HttpSession session) {


        return "";
    }
}
