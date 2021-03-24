package com.study.dubbo.facade;

import java.util.concurrent.CompletableFuture;

/**
 * 异步服务，用来测试 Dubbo 并发控制
 *
 * @author Hash
 * @since 2021/3/24
 */
public interface AsyncService {

    CompletableFuture<String> sayHello(String name);
}
