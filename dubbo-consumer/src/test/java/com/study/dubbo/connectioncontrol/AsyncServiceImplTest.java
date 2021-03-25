package com.study.dubbo.connectioncontrol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImplTest.class);

    @Autowired
    AsyncServiceImpl asyncService;

    @Test
    public void sayHello() {
        final String world = asyncService.sayHello("world");
        System.out.println(world);
    }

    @Test
    public void concurrentTest() {
        // 消费者数
        int consummerNum = 5;
        // 并发数
        int requestSize = 10;

        CyclicBarrier requestBarrier = new CyclicBarrier(requestSize * consummerNum);
        for (int i = 0; i < consummerNum; i++) {
            new Thread(() -> {
                // 模拟分布式集群的场景
                logger.info(Thread.currentThread().getName() + "---------我准备好---------------");
                for (int j = 0; j < requestSize; j++) {
                    new Thread(() -> {
                        try {
                            // 等待service台服务，requestSize个请求 一起出发
                            requestBarrier.await();
                        } catch (InterruptedException | BrokenBarrierException e) {
                            e.printStackTrace();
                        }

                        final String world = asyncService.sayHello("world");
                        logger.info("显示调用结果：" + world);
                    }).start();
                }
            }).start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}