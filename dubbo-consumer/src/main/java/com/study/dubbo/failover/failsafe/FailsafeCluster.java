package com.study.dubbo.failover.failsafe;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 失败安全，出现异常时，直接忽略（日志、监控信息查询）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class FailsafeCluster {

    @DubboReference(timeout = 500)
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
