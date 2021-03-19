package com.study.dubbo.failover.failover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class FailoverClusterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FailoverClusterConsumerApplication.class, args);
    }
}
