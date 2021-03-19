package com.study.dubbo.protocol.thrift;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hash
 * @since 2021/2/28
 */
@DubboService
public class HelloThriftProvider implements com.study.dubbo.protocol.thrift.HelloThrift.Iface {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloThriftProvider.class);

    @Override
    public String sayHello(String para) {
        LOGGER.info("thrift 开始执行 para [{}]", para);
        return "hello " + para + ", this is thrift.";
    }
}
