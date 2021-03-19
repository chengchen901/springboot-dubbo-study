package com.study.dubbo.mock;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

/**
 * 	mork参数有四种
 *  1、true，自动在相同包下面找接口名 + Mock后缀的实现类
 * 	2、false，不调用mock
 * 	3、String，指定调用的mock全限定名路径
 * 	4、表达式，return true; return null
 *
 * @author Hash
 * @since 2021/2/28
 */
@Component
public class OrderServiceImpl {

    // @DubboReference(timeout = 500, mock = "com.study.dubbo.mock.LocalOrderService")
    // @DubboReference(timeout = 500, mock = "com.study.dubbo.facade.OrderServiceMock")
    // 如果没有设置类全限定路径则在该接口的同包下找接口名称 + Mock的实现类，即OrderServiceMock
    // @DubboReference(timeout = 500, mock = "true")
     @DubboReference(timeout = 500, mock = "return null")
    private OrderService orderService;

    public String createOrder(OrderModel order) {
        return orderService.createOrder(order);
    }

    public OrderModel getOrder(String orderNo) {
        return orderService.getOrder(orderNo);
    }
}
