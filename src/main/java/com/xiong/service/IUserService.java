package com.xiong.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by gonghui on 2017/11/3.
 */
public interface IUserService {

    public ServerResponse<User> login(String name, String password);
    public ServerResponse<String> register(String name, String password, String mobile, String question, String anser);

}
