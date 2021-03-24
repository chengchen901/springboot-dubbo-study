package com.study.dubbo.configcenter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Hash
 * @since 2021/3/23
 */
public class ConfigCenterProvider {

    public static void main(String[] args) throws IOException {
        String config = "provider-config-center.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
        context.close();
    }
}
