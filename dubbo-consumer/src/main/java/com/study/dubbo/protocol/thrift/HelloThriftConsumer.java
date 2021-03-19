package com.study.dubbo.protocol.thrift;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

/**
 * @author Hash
 * @since 2021/2/28
 */
@Component
public class HelloThriftConsumer {

    @DubboReference
    private com.study.dubbo.protocol.thrift.HelloThrift.Iface helloThrift;

    public String sayHello(String para) throws TException {
        return helloThrift.sayHello(para);
    }
}
