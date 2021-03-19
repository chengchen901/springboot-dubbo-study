package com.study.dubbo.failover.failback;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 失败自动恢复，记录失败请求，定时重发（默认5秒重试，重试一定次数或直到服务找不到，场景短信发送场景）
 *
 * @author Hash
 * @since 2021/3/16
 */
@Component
public class FailbackCluster {

    @DubboReference(timeout = 500)
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
