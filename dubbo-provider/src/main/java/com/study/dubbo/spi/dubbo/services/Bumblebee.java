package com.study.dubbo.spi.dubbo.services;

import com.study.dubbo.spi.dubbo.Robot;

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
