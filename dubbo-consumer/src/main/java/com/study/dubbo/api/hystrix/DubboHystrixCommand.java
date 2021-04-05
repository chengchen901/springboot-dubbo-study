package com.study.dubbo.api.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DubboHystrixCommand extends HystrixCommand<Result> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Invoker<?> invoker;
    private Invocation invocation;

    protected DubboHystrixCommand(Setter setter, Invoker<?> invoker, Invocation invocation) {
        super(setter);
        this.invoker = invoker;
        this.invocation = invocation;
    }

    @Override
    protected Result run() throws Exception {
        logger.info("通过了熔断器发起调用");
        Result result = invoker.invoke(invocation);
        logger.info("调用成功，获得结果" + result);
        return result;
    }

    @Override
    protected Result getFallback() {
        logger.info("调用Fallback方法");
        return null;
    }
}
