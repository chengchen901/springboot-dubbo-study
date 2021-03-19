package com.study.dubbo.loadbalance.leastactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/14
 */
@SpringBootApplication
public class LeastActiveLoadBalanceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeastActiveLoadBalanceConsumerApplication.class, args);
    }
}
