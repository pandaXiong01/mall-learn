package com.xiong.service.impl;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.xiong.common.exceptions.ValidationException;
import com.xiong.dao.TransactionMapper;
import com.xiong.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gonghui on 2017/11/29.
 */
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private TransactionMapper mapper;

    @Override
    @Transactional()//isolation = Isolation.SERIALIZABLE
    public void transfer(String fromUuid, String toUUid, BigDecimal amount) {

        BigDecimal fromAmount = mapper.getUserAmount(fromUuid);
        BigDecimal toAmount = mapper.getUserAmount(toUUid);

        if (fromAmount.compareTo(amount) == -1) {
            throw new ValidationException("金额不足!");
        }

        fromAmount = fromAmount.subtract(amount);
        toAmount = toAmount.add(amount);

        /**
         * 什么情况下回滚
         * mapper.updateUserAmount("73494087947i", toAmount); 没有回滚
         */

        int result = mapper.updateUserAmount(fromUuid, fromAmount);
        int result2 = mapper.updateUserAmount(toUUid, toAmount);
        if (result != 1 || result2 != 1) {
            throw new ValidationException("网路不给力");
        }

    }

    @Override
    @Transactional
    public void paySalary(String payUuid, String jsonData, String password) {

        List<Map<String, String>> maps = jsonDataTransfer(jsonData);

        for (Map<String, String> map : maps) {

            String toUUid = map.get("uuid");
            BigDecimal amount = new BigDecimal(map.get("amount"));

            BigDecimal fromAmount = mapper.getUserAmount(payUuid);
            BigDecimal toAmount = mapper.getUserAmount(toUUid);
            if (fromAmount.compareTo(amount) == -1) {
                throw new ValidationException("金额不足!");
            }

            fromAmount = fromAmount.subtract(amount);
            toAmount = toAmount.add(amount);

            /**
             * 什么情况下回滚
             * mapper.updateUserAmount("73494087947i", toAmount); 没有回滚
             */

            int result = mapper.updateUserAmount(payUuid, fromAmount);
            int result2 = mapper.updateUserAmount(toUUid, toAmount);
            if (result != 1 || result2 != 1) {
                throw new ValidationException("网路不给力");
            }


        }



    }




    private List<Map<String, String>> jsonDataTransfer(String jsonData) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("uuid","57fd5ff12ba74f25b561ce7e46f1012f");
        map1.put("amount","100");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("uuid","b4fd35b8837249a58c10bbf2b57c5ade");
        map2.put("amount","100");
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("uuid","c62b288b535c4f29a629115e6ce5597a");
        map3.put("amount","6000");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;

    }

    /**
     * 加减乘除
     */
//        fromAmount.add(amount);
//        fromAmount.subtract(amount);
//        fromAmount.multiply(amount);
//        fromAmount = fromAmount.divide(amount);

}
