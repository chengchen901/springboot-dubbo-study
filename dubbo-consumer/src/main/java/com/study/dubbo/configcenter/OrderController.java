package com.study.dubbo.configcenter;

import com.study.dubbo.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hash
 * @since 2021/3/22
 */
@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping(value = "/createOrder")
    public String createOrder() {
        OrderModel order = new OrderModel();
        order.setOrderName("充值订单");
        order.setOrderType(2);
        order.setUserId("12306");
        order.setOrderNo("");
        return orderService.createOrder(order);
    }

    @RequestMapping(value = "/getOrder")
    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder("1");
    }

}
