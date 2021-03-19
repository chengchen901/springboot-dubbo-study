package com.study.dubbo.failover.failback;

import com.study.dubbo.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FailbackClusterTest {

    @Autowired
    FailbackCluster failbackCluster;

    @Test
    public void createOrder() {
        OrderModel order = new OrderModel();
        order.setOrderName("充值订单");
        order.setOrderType(1);
        order.setUserId("12306");
        order.setOrderNo("");
        try {
            final String orderNo = failbackCluster.createOrder(order);
            System.out.println(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOrder() {
        final OrderModel order = failbackCluster.getOrder( "1");
        System.out.println(order);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}