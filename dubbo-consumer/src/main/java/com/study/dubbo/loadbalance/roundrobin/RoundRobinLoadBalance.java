package com.study.dubbo.loadbalance.roundrobin;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 轮询，按公约后的权重设置轮询比率
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class RoundRobinLoadBalance {

    @DubboReference(timeout = 1500, loadbalance = "roundrobin")
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
