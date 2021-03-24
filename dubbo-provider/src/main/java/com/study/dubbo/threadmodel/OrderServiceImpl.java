package com.study.dubbo.threadmodel;

import com.study.dubbo.facade.OrderService;
import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * dispatcher 消息派遣方式
 * 1. all所有消息都派发到线程池，包括请求，响应，连接事件，断开事件，心跳等。
 * 2. direct 所有消息都不派发到线程池，全部在IO线程上直接执行。 
 * 3. message只有请求响应消息派发到线程池，其它连接断开事件，心跳等消息，直接在IO线程上执行。
 * 4. execution只请求消息派发到线程池，不含响应，响应和其它连接断开事件，心跳等消息，直接在IO线程上执行。
 * 5. connection在IO线程上，将连接断开事件放入队列，有序逐个执行，其它消息派发到线程池。  
 *
 * threadpool 线程池配置
 * 1. fixed固定大小线程池，启动时建立线程，不关闭，一直持有。（缺省）
 * 2. cached 缓存线程池，空闲一分钟自动删除，需要时重建。 
 * 3. limited可伸缩线程池，但池中的线程数只会增长不会收缩。只增长不收缩的目的是为了避免收缩时突然来了大流量 引起的性能问题。 
 * 4. eager优先创建Worker线程池。在任务数量大于corePoolSize但是小于maximumPoolSize时，优先创建Worker来处理任务。
 *    当任务数量大于maximumPoolSize时，将任务放入阻塞队列中。阻塞队列充满时抛出 RejectedExecutionException。
 *    （相比于cached∶cached在任务数量超过maximumPoolSize时直接抛出异常而不是将任务放入阳塞队列）  
 *
 * @author Hash
 * @since 2021/2/28
 */
@DubboService
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    private AtomicInteger orderNo = new AtomicInteger(0);

    @Override
    public String createOrder(OrderModel order) {
        LOGGER.info("创建订单，收到参数请求：" + order.toString());
        String newOrderNo = String.valueOf(orderNo.incrementAndGet());

        if (Integer.parseInt(newOrderNo) % 2 == 1) {
            String str = null;
            str.equals("");
        }

        // 执行业务代码
        // 。。。。。
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        order.setOrderNo(newOrderNo);
        LOGGER.info("处理结果："+order.toString());
        return newOrderNo;
    }

    @Override
    public OrderModel getOrder(String orderNo) {
        LOGGER.info("查询订单，收到参数："+orderNo);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OrderModel order = new OrderModel();
        order.setOrderName("交易订单");
        order.setOrderType(2);
        order.setUserId("12307");
        order.setOrderNo(orderNo);
        LOGGER.info("查询订单，返回结果："+order);
        return order;
    }
}
