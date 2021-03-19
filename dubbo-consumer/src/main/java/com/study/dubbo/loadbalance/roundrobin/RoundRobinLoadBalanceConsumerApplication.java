package com.study.dubbo.loadbalance.roundrobin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/14
 */
@SpringBootApplication
public class RoundRobinLoadBalanceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoundRobinLoadBalanceConsumerApplication.class, args);
    }
}
