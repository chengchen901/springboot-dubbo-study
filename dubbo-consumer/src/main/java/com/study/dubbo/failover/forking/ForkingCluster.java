package com.study.dubbo.failover.forking;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 并行调用多个服务器，只要一个成功即返回（消耗资源，更可靠，快速返回）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class ForkingCluster {

    @DubboReference(timeout = 500)
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
