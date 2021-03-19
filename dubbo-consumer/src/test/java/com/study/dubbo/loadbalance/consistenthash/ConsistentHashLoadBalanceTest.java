package com.study.dubbo.loadbalance.consistenthash;

import com.study.dubbo.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsistentHashLoadBalanceTest {

    @Autowired
    ConsistentHashLoadBalance consistentHashLoadBalance;

    @Test
    public void createOrder() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                OrderModel order = new OrderModel();
                order.setOrderName("充值订单");
                order.setOrderType(j);
                order.setUserId("12306");
                order.setOrderNo("");
                final String orderNo = consistentHashLoadBalance.createOrder(order);
                System.out.println(orderNo);
            }
        }
    }

    @Test
    public void getOrder() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                final OrderModel order = consistentHashLoadBalance.getOrder(j + "");
                System.out.println(order);
            }
        }
    }
}