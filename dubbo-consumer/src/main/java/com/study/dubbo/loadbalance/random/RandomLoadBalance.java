package com.study.dubbo.loadbalance.random;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 随机，按权重设置随机概率（默认）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class RandomLoadBalance {

    @DubboReference(timeout = 1500, loadbalance = "random")
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
