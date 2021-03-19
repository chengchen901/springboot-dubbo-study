package com.study.dubbo.registry;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;
import org.apache.dubbo.registry.support.AbstractRegistryFactory;

/**
 * @author Hash
 * @since 2021/3/16
 */
public class CustomRegistryFactory extends AbstractRegistryFactory implements RegistryFactory {

    @Override
    public Registry getRegistry(URL url) {
        System.out.println("获取CustomRegistry");
        return super.getRegistry(url);
    }

    @Override
    protected Registry createRegistry(URL url) {
        return new CustomRegistry(url);
    }
}
