package com.xiong.service;

import java.math.BigDecimal;

/**
 * Created by gonghui on 2017/11/29.
 */
public interface TransactionService {

    void transfer(String fromUuid, String toUUid, BigDecimal amount);

    void paySalary(String payUuid, String data, String password);

}
