package com.xiong.service;

import com.xiong.pojo.XUser;

/**
 * Created by gonghui on 2017/11/21.
 */
public interface UserService {
    XUser login(String mobile, String password);

    void register(XUser user);

    void updateUserInfo(XUser user);

}
