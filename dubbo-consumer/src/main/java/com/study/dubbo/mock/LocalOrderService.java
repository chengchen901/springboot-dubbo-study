package com.study.dubbo.mock;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Hash
 * @since 2021/3/16
 */
public class LocalOrderService implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalOrderService.class);
    private AtomicInteger orderNo = new AtomicInteger(0);

    @Override
    public String createOrder(OrderModel order) {
        LOGGER.info("创建订单，收到参数请求：" + order.toString());
        String newOrderNo = String.valueOf(orderNo.incrementAndGet());

        order.setOrderNo(newOrderNo);
        LOGGER.info("处理结果："+order.toString());
        return newOrderNo;
    }

    @Override
    public OrderModel getOrder(String orderNo) {
        LOGGER.info("查询订单，收到参数："+orderNo);
        OrderModel order = new OrderModel();
        order.setOrderName("交易订单");
        order.setOrderType(2);
        order.setUserId("12307");
        order.setOrderNo(orderNo);
        LOGGER.info("查询订单，返回结果："+order);
        return order;
    }
}
