package com.study.dubbo.failover.forking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class ForkingClusterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForkingClusterConsumerApplication.class, args);
    }
}
