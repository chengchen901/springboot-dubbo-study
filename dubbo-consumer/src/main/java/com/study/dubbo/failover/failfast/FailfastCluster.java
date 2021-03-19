package com.study.dubbo.failover.failfast;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 快速失败，立即报错，只发起一次调用（需要保证幂等性的服务，例如插入数据）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class FailfastCluster {

    @DubboReference(timeout = 500)
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
