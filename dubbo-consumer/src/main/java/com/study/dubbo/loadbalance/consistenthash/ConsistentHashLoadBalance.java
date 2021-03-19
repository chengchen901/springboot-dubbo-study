package com.study.dubbo.loadbalance.consistenthash;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 一致性Hash，相同参数的请求总是发到同一提供者
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class ConsistentHashLoadBalance {

    @DubboReference(timeout = 1500, loadbalance = "consistenthash")
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
