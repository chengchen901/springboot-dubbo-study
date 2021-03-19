package com.study.dubbo.failover.failfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class FailfastClusterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FailfastClusterConsumerApplication.class, args);
    }
}
