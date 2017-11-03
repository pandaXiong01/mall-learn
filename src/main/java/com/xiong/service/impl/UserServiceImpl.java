package com.xiong.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.xiong.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by gonghui on 2017/11/3.
 */
@Service()
public class UserServiceImpl implements IUserService {

    @Override
    public ServerResponse<User> login(String name, String password) {
        return null;
    }

    @Override
    public ServerResponse<String> register(String name, String password, String mobile, String question, String anser) {
        return null;
    }
}
