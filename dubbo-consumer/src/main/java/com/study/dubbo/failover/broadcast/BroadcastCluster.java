package com.study.dubbo.failover.broadcast;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 广播逐个调用所有提供者，任意一个报错则报错（测试，配置中心，缓存更新场景）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class BroadcastCluster {

    @DubboReference(timeout = 1500)
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
