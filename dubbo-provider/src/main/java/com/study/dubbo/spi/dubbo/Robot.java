package com.study.dubbo.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author Hash
 * @since 2021/3/16
 */
@SPI("bumblebee")
public interface Robot {

    void sayHello();
}
