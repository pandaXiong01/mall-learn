package com.mmall.test;

import com.xiong.common.exceptions.ValidationException;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by gonghui on 2017/11/17.
 */
public class SimpleTest {

    @Test
    public void testBigDe() {
        BigDecimal amount = new BigDecimal(500.000);
        int result = amount.compareTo(BigDecimal.ZERO);
        System.out.printf("hahah" + result);
    }


    @Test
    public void testUUID () {
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }

    }
    @Test
    public void testExtension() {

        String msg = doTest();
        if (!msg.isEmpty()) {
            System.out.print("/////////" + msg);
        }
        doTest1();
    }

    String doTest() {
        try {
            doThrow();

        } catch (ValidationException e) {
//            return "错了";
            e.printStackTrace();
        }


        return "haha";
    }

    void doTest1() {
        try {
            doThrow();
            System.out.print("/////////" + "执行到这里try后面");
        } catch (ValidationException e) {
            e.printStackTrace();
        } finally {
            System.out.print("/////////" + "执行到这里finally");
        }
        System.out.print("/////////" + "执行到这里");
    }
    void doThrow() throws ValidationException {
        int a = 10;
        int b = 0;
        throw new ValidationException("参数错误");

    }

}
