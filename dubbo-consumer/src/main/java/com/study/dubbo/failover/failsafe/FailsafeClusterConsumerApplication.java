package com.study.dubbo.failover.failsafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class FailsafeClusterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FailsafeClusterConsumerApplication.class, args);
    }
}
