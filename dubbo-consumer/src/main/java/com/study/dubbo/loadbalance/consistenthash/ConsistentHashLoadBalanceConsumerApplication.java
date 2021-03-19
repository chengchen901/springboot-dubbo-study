package com.study.dubbo.loadbalance.consistenthash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/14
 */
@SpringBootApplication
public class ConsistentHashLoadBalanceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsistentHashLoadBalanceConsumerApplication.class, args);
    }
}
