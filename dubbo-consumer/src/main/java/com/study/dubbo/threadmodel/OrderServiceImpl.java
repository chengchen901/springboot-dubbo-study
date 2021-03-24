package com.study.dubbo.threadmodel;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * @author Hash
 * @since 2021/2/28
 */
@Component
public class OrderServiceImpl {

    @DubboReference(timeout = 1500)
    private OrderService orderService;

    @DubboReference(timeout = 1500)
    private OrderService orderService2;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService2.getOrder(orderNo);
    }
}
