package com.study.dubbo.spi.java.service;

import com.study.dubbo.spi.java.Robot;

/**
 * @author Hash
 * @since 2021/3/16
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
