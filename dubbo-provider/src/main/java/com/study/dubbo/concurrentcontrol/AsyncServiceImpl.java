package com.study.dubbo.concurrentcontrol;

import com.study.dubbo.facade.AsyncService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * executes: 服务的最大并发执行数，默认值为0 -没有限制
 * actives: 允许的最大活动请求数，默认值为0
 *
 * @author Hash
 * @since 2021/3/24
 */
@DubboService(executes = 10, actives = 5)
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext savedContext = RpcContext.getContext();
        final String argName = name;
        return CompletableFuture.supplyAsync(() -> {
            String key = savedContext.getAttachment("consumer-key1");
            logger.info("key值为：" + key);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello " + argName + ". this is async response from provider, for consummer key: " + key;
        });
    }
}
