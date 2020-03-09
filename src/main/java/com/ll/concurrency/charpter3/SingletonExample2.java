package com.ll.concurrency.charpter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于静态内部类的单例模式的实现
 */
public class SingletonExample2 {

    public static Logger log = LoggerFactory.getLogger(SingletonExample2.class);
    //私有构造器
    private SingletonExample2(){
        log.info("StaticHolderSingleton inited.");
    }

    private static class InstanceHolder{
        //保存外部类的唯一实例
        final static SingletonExample2 INSTANCE = new SingletonExample2();
    }

    public static SingletonExample2 getInstance(){
        log.info("getInstance Invoked!");
        return InstanceHolder.INSTANCE;
    }

    public void someService(){
        //do everything you like
    }

    public static void main(String[] args) {
        SingletonExample2.getInstance().someService();
    }
}
