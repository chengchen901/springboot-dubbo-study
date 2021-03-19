package com.study.dubbo.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class RobotTest {

    @Test
    public void sayHello() {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);

        Robot defaultRobot = extensionLoader.getDefaultExtension();
        defaultRobot.sayHello();

        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}