package com.study.dubbo.serialization.kryo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hash
 * @since 2021/3/14
 */
@SpringBootApplication
public class KryoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KryoConsumerApplication.class, args);
    }
}
