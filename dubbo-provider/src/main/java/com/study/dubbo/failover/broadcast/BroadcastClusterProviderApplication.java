package com.study.dubbo.failover.broadcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class BroadcastClusterProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BroadcastClusterProviderApplication.class, args);
    }
}
