package com.study.dubbo.failover.broadcast;

import com.study.dubbo.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BroadcastClusterTest {

    @Autowired
    BroadcastCluster broadcastCluster;

    @Test
    public void createOrder() {
        OrderModel order = new OrderModel();
        order.setOrderName("充值订单");
        order.setOrderType(1);
        order.setUserId("12306");
        order.setOrderNo("");
        final String orderNo = broadcastCluster.createOrder(order);
        System.out.println(orderNo);
    }

    @Test
    public void getOrder() {
        final OrderModel order = broadcastCluster.getOrder( "1");
        System.out.println(order);
    }
}