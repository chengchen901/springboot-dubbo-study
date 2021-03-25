package com.study.dubbo.connectioncontrol;

import com.study.dubbo.facade.AsyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Hash
 * @since 2021/3/24
 */
@Component
public class AsyncServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    /**
     * connections = 1，客户端连接控制为1
     * sticky = true 开启粘滞连接
     * lazy = true 开启延迟连接
     */
    @DubboReference(connections = 1, sticky = true, lazy = true)
    private AsyncService asyncService;

    private AtomicInteger currentNo = new AtomicInteger(0);

    public String sayHello(String name) {
        final int number = currentNo.incrementAndGet();
        logger.info("消费者Key：" + number);
        RpcContext.getContext().setAttachment("consumer-key1", String.valueOf(number));
        CompletableFuture<String> future = asyncService.sayHello(name);

        String result = null;
        try {
            result = future.get();
            logger.info("异步方法返回结果：" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
