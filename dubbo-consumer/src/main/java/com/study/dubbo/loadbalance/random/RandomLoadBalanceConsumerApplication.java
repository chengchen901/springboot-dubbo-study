package com.study.dubbo.loadbalance.random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/14
 */
@SpringBootApplication
public class RandomLoadBalanceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomLoadBalanceConsumerApplication.class, args);
    }
}
