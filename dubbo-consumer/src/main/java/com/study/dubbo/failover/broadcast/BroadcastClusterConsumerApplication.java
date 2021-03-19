package com.study.dubbo.failover.broadcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class BroadcastClusterConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BroadcastClusterConsumerApplication.class, args);
    }
}
