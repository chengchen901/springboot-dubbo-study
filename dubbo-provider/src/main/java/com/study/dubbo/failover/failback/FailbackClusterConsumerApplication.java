package com.study.dubbo.failover.failback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class FailbackClusterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FailbackClusterConsumerApplication.class, args);
    }
}
