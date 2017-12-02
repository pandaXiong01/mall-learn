package com.mmall.dao.test;

import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.test.TestBase;
import com.xiong.dao.ProjectMapper;
import com.xiong.vo.ProjectMember;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by geely on mmall.
 */
public class DaoTest extends TestBase {

    @Autowired
    private ProjectMapper mapper;


    @Test
    public void testDao(){

        List<ProjectMember> list = mapper.getProjectMember("3c686b98d1fe4b18a907dc867facc023");
        print(list);
    }


    void print(Object object) {
        System.out.print(object);
    }
}
