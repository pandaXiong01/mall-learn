package com.xiong.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.xiong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gonghui on 2017/11/3.
 */
@Service()
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String name, String password) {
        User user = userMapper.selectLogin(name, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码不正确！");
        } else {

            return ServerResponse.createBySuccess(user);
        }
    }

    @Override
    public ServerResponse<String> register(String name, String password, String mobile, String question, String anser) {
        return null;
    }
}
