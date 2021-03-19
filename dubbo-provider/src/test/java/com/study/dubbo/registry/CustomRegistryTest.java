package com.study.dubbo.registry;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.junit.Test;

import java.io.IOException;

public class CustomRegistryTest {

    @Test
    public void test() {
        ExtensionLoader<RegistryFactory> extensionLoader = ExtensionLoader.getExtensionLoader(RegistryFactory.class);
        RegistryFactory registryFactory = extensionLoader.getExtension("customRegistryFactory");
        // zookeeper://localhost:2181/org.apache.dubbo.registry.RegistryService?application=demo-service-provider&client=zkclient&dubbo=2.6.1&export=dubbo://192.168.56.1:28080/com.study.dubbo.DemoService?anyhost=true&application=demo-service-provider&bind.ip=192.168.56.1&bind.port=28080&dubbo=2.6.1&generic=false&interface=com.study.dubbo.DemoService&methods=test,say&pid=20296&serialization=fastjson&side=provider&timestamp56006021065&pid=20296&timestamp=1556006021065
        URL url = URL.valueOf("zookeeper://localhost:2181/org.apache.dubbo.registry.RegistryService?application=demo-service-provider&client=zkclient&dubbo=2.6.1&export=dubbo%3A%2F%2F192.168.30.18%3A28080%2Fcom.study.dubbo.DemoService%3Fanyhost%3Dtrue%26application%3Ddemo-service-provider%26bind.ip%3D192.168.56.1%26bind.port%3D28080%26dubbo%3D2.6.1%26generic%3Dfalse%26interface%3Dcom.study.dubbo.DemoService%26methods%3Dtest%2Csay%26pid%3D20296%26serialization%3Dfastjson%26side%3Dprovider%26timestamp%1556006021065&pid=20296&timestamp=1556006021065");
        Registry registry = registryFactory.getRegistry(url);
        // dubbo://192.168.30.18:30880/com.study.dubbo.facade.OrderService?anyhost=true&application=simple-provider&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.study.dubbo.facade.OrderService&methods=createOrder,getOrder&pid=3388&release=2.7.7&side=provider&timestamp=1615896345207
        URL rigstUrl = URL.valueOf("dubbo://192.168.30.18:30880/com.study.dubbo.facade.OrderService?anyhost=true&application=simple-provider&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.study.dubbo.facade.OrderService&methods=createOrder,getOrder&pid=3388&release=2.7.7&side=provider&timestamp=1615896345207");
        registry.register(rigstUrl);
        registry.subscribe(rigstUrl, urls -> {
            System.out.println("监听到变化："+urls);
        });
        registry.unregister(rigstUrl);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}