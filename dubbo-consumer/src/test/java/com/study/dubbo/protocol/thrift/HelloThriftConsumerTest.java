package com.study.dubbo.protocol.thrift;

import com.study.dubbo.protocol.thrift.HelloThriftConsumer;
import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloThriftConsumerTest {

    @Autowired
    HelloThriftConsumer helloThriftConsumer;

    @Test
    public void sayHello() throws TException {
        final String result = helloThriftConsumer.sayHello("word");
        System.out.println(result);
    }
}