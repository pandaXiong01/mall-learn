package com.mmall.service.test;

import com.google.common.collect.Lists;
import com.mmall.test.TestBase;
import com.xiong.service.TransactionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
public class ProductServiceTest extends TestBase {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testUserService(){
//        BigDecimal amount = new BigDecimal(500.000);
//       transactionService.transfer("c62b288b535c4f29a629115e6ce5597a","fd505aa2d0434f31995c87d522672022", amount);

       transactionService.paySalary("48aafa5467dd4fed83421d8b9ce9a880","","");

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
