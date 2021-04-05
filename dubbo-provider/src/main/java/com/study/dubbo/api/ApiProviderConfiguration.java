package com.study.dubbo.api;

import org.apache.dubbo.config.ServiceConfig;
import com.study.dubbo.facade.OrderService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hash
 * @since 2021/4/3
 */
public class ApiProviderConfiguration {

    public static void main(String[] args) throws IOException {
        // 服务实现
        OrderService orderService = new OrderServiceImpl();

        // 当前应用配置。 请学习ApplicationConfig的API
        ApplicationConfig application = new ApplicationConfig();
        application.setName("hello-world-app");
        Map<String, String> appParameters = new HashMap<String, String>();
        appParameters.put("qos.enable", "false");
        application.setParameters(appParameters);

        // 连接注册中心配置。 请学习RegistryConfig的API
        RegistryConfig registry = new RegistryConfig("127.0.0.1:2181", "zookeeper");
        //registry.setDynamic(true);  // 动态注册，服务出现问题自动处理

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(12345);
        protocol.setThreads(200);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置。请学习ServiceConfig的API
        // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        ServiceConfig<OrderService> service = new ServiceConfig<OrderService>();
        service.setApplication(application);
        // 多个注册中心可以用setRegistries()
        service.setRegistry(registry);
        // 多个协议可以用setProtocols()
        service.setProtocol(protocol);
        service.setInterface(OrderService.class);
        service.setRef(orderService);
        service.setVersion("1.0.0");
        // service.setModule();

        // 暴露及注册服务
        service.export();

        System.in.read();
    }
}
