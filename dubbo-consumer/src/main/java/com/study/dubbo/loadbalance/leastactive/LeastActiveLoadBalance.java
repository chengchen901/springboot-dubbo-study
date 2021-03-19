package com.study.dubbo.loadbalance.leastactive;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 最少活跃调用数，相同活跃数的随机
 *
 * LeastActive LoadBalance：例如有10个请求，发送到3台机器，A每秒处理8个，B每秒处理5个，C每秒处理3个，
 * 请求前计数10，每响应回来10减1，最后数最小的表示处理能力越强，则大部分请求都发送到该服务者。
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class LeastActiveLoadBalance {

    @DubboReference(timeout = 1500, loadbalance = "leastactive")
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
