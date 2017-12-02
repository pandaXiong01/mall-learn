package com.xiong.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Created by gonghui on 2017/11/29.
 */
public interface TransactionMapper {

    int updateUserAmount(@Param("userId") String userId, @Param("amount") BigDecimal amount);
    BigDecimal getUserAmount(String userId);


}
