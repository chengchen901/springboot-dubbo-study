package com.study.dubbo.manage;

import com.study.dubbo.model.OrderModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImplTest.class);

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void manageTest() {
        Executor executor = Executors.newFixedThreadPool(5);
        // 写操作
        executor.execute(()->{
            while(true) {
                OrderModel order = new OrderModel();
                order.setOrderName("充值订单");
                order.setOrderType(1);
                order.setUserId("12306");
                String orderNo = orderService.createOrder(order); // 执行远程方法
                logger.info("创建订单成功，获得编号："+orderNo);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 读操作
        executor.execute(()->{
            while(true) {
                OrderModel order = orderService.getOrder("123"); // 执行远程方法
                logger.info("查询订单成功，获得订单内容："+order);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}