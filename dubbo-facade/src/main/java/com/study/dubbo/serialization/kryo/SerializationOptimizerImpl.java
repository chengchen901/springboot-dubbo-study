package com.study.dubbo.serialization.kryo;

import com.study.dubbo.model.OrderModel;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 官网地址：https://dubbo.apache.org/zh/docs/v2.7/user/serialization/
 *
 * <p>
 * 要让Kryo和FST完全发挥出高性能，最好将那些需要被序列化的类注册到dubbo系统中
 *
 * 然后在配置中添加 dubbo.protocol.optimizer=com.study.dubbo.kryo.SerializationOptimizerImpl
 *
 * 在注册这些类后，序列化的性能可能被大大提升，特别针对小数量的嵌套对象的时候。
 *
 * 当然，在对一个类做序列化的时候，可能还级联引用到很多类，比如Java集合类。针对这种情况，我们已经自动将JDK中的常用类进行了注册，所以你不需要重复注册它们（当然你重复注册了也没有任何影响），包括：
 * </p>
 *
 * <p>
 * 如果被序列化的类中不包含无参的构造函数，则在Kryo的序列化中，性能将会大打折扣，因为此时我们在底层将用Java的序列化来透明的取代Kryo序列化。
 * 所以，尽可能为每一个被序列化的类添加无参构造函数是一种最佳实践（当然一个java类如果不自定义构造函数，默认就有无参构造函数）。
 *
 * 另外，Kryo和FST本来都不需要被序列化都类实现Serializable接口，但我们还是建议每个被序列化类都去实现它，因为这样可以保持和Java序列化以及dubbo
 * 序列化的兼容性，另外也使我们未来采用上述某些自动注册机制带来可能。
 * </p>
 *
 * @author Hash
 * @since 2021/3/15
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {
    @Override
    public Collection<Class<?>> getSerializableClasses() {
        List<Class<?>> classes = new LinkedList<Class<?>>();
        classes.add(OrderModel.class);
        classes.add(String.class);
        return classes;
    }
}
