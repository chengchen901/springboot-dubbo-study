package com.study.dubbo.loadbalance.roundrobin;

import com.study.dubbo.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundRobinLoadBalanceTest {

    @Autowired
    RoundRobinLoadBalance roundRobinLoadBalance;

    @Test
    public void createOrder() {
        for (int i = 0; i < 10; i++) {
            OrderModel order = new OrderModel();
            order.setOrderName("充值订单");
            order.setOrderType(i);
            order.setUserId("12306");
            order.setOrderNo("");
            final String orderNo = roundRobinLoadBalance.createOrder(order);
            System.out.println(orderNo);
        }
    }

    @Test
    public void getOrder() {
        for (int i = 0; i < 10; i++) {
            final OrderModel order = roundRobinLoadBalance.getOrder(i + "");
            System.out.println(order);
        }
    }
}