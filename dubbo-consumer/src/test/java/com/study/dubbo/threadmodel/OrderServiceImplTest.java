package com.study.dubbo.threadmodel;

import com.study.dubbo.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Hash
 * @since 2021/3/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void createOrder() {
        OrderModel order = new OrderModel();
        order.setOrderName("充值订单");
        order.setOrderType(1);
        order.setUserId("12306");
        order.setOrderNo("");
        final String orderNo = orderService.createOrder(order);
        System.out.println(orderNo);
    }

    @Test
    public void getOrder() {
        final OrderModel order = orderService.getOrder("1");
        System.out.println(order);
    }
}
