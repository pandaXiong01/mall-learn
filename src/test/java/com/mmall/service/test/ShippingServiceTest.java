package com.mmall.service.test;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;
import com.mmall.service.impl.ShippingServiceImpl;
import com.mmall.test.TestBase;
import com.mmall.util.JSONUtil;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by geely
 */
public class ShippingServiceTest extends TestBase {

    private Logger logger = LoggerFactory.getLogger(ShippingServiceTest.class);


    @Autowired
    private ShippingServiceImpl iShippingService;

    @Test
    public void testSelect(){
        ServerResponse sr = iShippingService.select(1, 3);
        Shipping shipping = (Shipping)sr.getData();
        logger.info(ToStringBuilder.reflectionToString(shipping));

    }

    @Test
    public void testList(){
        ServerResponse sr = iShippingService.list(1,1,2);
        PageInfo<Shipping> p=(PageInfo<Shipping>)sr.getData();
        logger.info("======");
        logger.info(JSONUtil.toJson(p));
        logger.info("======");



    }



}
