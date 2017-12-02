package com.xiong.controller;

import com.xiong.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by gonghui on 2017/11/29.
 */
@Controller
@RequestMapping("Transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @RequestMapping("transfer")
    @ResponseBody
    public void transfer(String fromUuid, String toUUid, BigDecimal amount) {
        transactionService.transfer(fromUuid, toUUid, amount);
    }

    @RequestMapping("paySalary")
    @ResponseBody
    public void paySalary(String payUuid, String payData, String password) {
        transactionService.paySalary(payUuid, payData, password);
    }

}
