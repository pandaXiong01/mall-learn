package com.mmall.service.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mmall.common.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.test.TestBase;
import com.xiong.pojo.XUser;
import com.xiong.service.UserService;
import com.xiong.util.UUIDUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.plugin.util.UIUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
public class ProductServiceTest extends TestBase {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService(){


        XUser user = new XUser();
        user.setAnswer("haa");
        user.setAmount(new BigDecimal(100));
        user.setUserName("pandaXiong");
        user.setPassword("123456");
        user.setEmail("11@163.com");
        user.setPhone("1159508433");
        user.setAnswer("jsopodp");
        user.setUserId(UUIDUtil.getUUID());
        userService.register(user);

    }

    public static void main(String[] args) {
        List<String> images = Lists.newArrayList();
        images.add("mmall/aa.jpg");
        images.add("mmall/bb.jpg");
        images.add("mmall/cc.jpg");
        images.add("mmall/dd.jpg");
        images.add("mmall/ee.jpg");
//        ["mmall/aa.jpg","mmall/bb.jpg","mmall/cc.jpg","mmall/dd.jpg","mmall/ee.jpg"]
    }
}
