package com.study.dubbo.facade;

import com.study.dubbo.model.OrderModel;

/**
 * @author Hash
 * @since 2021/2/28
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     * @return
     */
    String createOrder(OrderModel order);

    /**
     * 查询订单信息
     * @param orderNo
     * @return
     */
    OrderModel getOrder(String orderNo);
}
