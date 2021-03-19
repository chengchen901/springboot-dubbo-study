package com.study.dubbo.failover.failover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SpringBootApplication
public class FailoverClusterProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FailoverClusterProviderApplication.class, args);
    }
}
