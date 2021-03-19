package com.study.dubbo.failover.failover;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 失败自动切换，自动重试其它服务器（默认，需要考虑服务幂等性问题）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class FailoverCluster {

    @DubboReference(timeout = 500)
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
