package com.xiong.service.impl;

import com.xiong.common.exceptions.ValidationException;
import com.mmall.util.MD5Util;
import com.xiong.dao.XUserMapper;
import com.xiong.pojo.XUser;
import com.xiong.service.UserService;
import com.xiong.util.Check;
import com.xiong.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by gonghui on 2017/11/21.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private XUserMapper userMapper;
    @Override
    public XUser login(String mobile, String password) {

        Check.isEmpty(mobile,"手机号不能为空");
        Check.isEmpty(password,"密码不能为空");
        String md5Pwd = MD5Util.MD5EncodeUtf8(password);
        XUser user = userMapper.selectLogin(mobile, md5Pwd);
        if (user == null) {
            throw new ValidationException("账号或者密码错误！");
        }
        user.setPassword("");
        return user;
    }

    @Override
    public void register(XUser user) {

        Check.isEmpty(user.getUserName(),"姓名不能为空");
        Check.isEmpty(user.getPassword(),"密码不能为空");
        Check.isEmpty(user.getPhone(), "手机号不能为空");
        int count = userMapper.checkMobile(user.getPhone());
        if (count != 0) {
            throw new ValidationException("该手机号已注册");
        }
        String password = MD5Util.MD5EncodeUtf8(user.getPassword());
        user.setPassword(password);
        user.setUserId(UUIDUtil.getUUID());
        int result = userMapper.insert(user);
    }


}
