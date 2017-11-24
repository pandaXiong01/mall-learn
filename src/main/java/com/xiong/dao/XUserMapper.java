package com.xiong.dao;

import com.xiong.pojo.XUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by gonghui on 2017/11/23.
 */
public interface XUserMapper {

    int insert(XUser user);

    int updateByPrimaryKeySelective(XUser user);

    int checkMobile(String mobile);

    XUser selectLogin(@Param("mobile") String mobile, @Param("password")String password);

    int selectUserInfoByPrimaryKey(String userId);

}
