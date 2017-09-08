package com.relenxing.config;

import com.relenxing.domain.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ReplayProcessor;


public class ReBus {

    /**
     * 事件总线的核心。
     */
    private final ReplayProcessor<Event> bus;

    /**
     * 构造函数，初始化
     */
    private ReBus() {
        bus = ReplayProcessor.create();
    }

    /**
     * 单例模式
     */
    public static ReBus getDefault() {
        return HelperHolder.instance;
    }

    /**
     * 延迟初始化，这里是利用了 Java 的语言特性，内部类只有在使用的时候，才会去加载，
     * 从而初始化内部静态变量。关于线程安全，这是 Java 运行环境自动给你保证的，
     * 在加载的时候，会自动隐形的同步。在访问对象的时候，
     * 不需要同步 Java 虚拟机又会自动给你取消同步，所以效率非常高。
     */
    private static class HelperHolder {
        static final ReBus instance = new ReBus();
    }


    /**
     * 发送普通事件
    */
    public void post(Event event){
        bus.onNext(event);
    }

    public  Flux<Event> on(String type){
        return bus.filter(e -> e.getEventName().equals(type));
    }


}
