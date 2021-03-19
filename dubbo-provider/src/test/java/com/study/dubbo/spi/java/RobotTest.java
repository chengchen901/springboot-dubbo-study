package com.study.dubbo.spi.java;

import org.junit.Test;

import java.util.ServiceLoader;

public class RobotTest {

    @Test
    public void sayHello() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}