package com.ll.concurrency.charpter3;

/**
 * 基于双重检查锁定的正确单例模式的实现
 */
public class SingletonExample1 {

    /**
     * 保存该类的唯一实例，使用volatile关键字修饰instance
     */
    private static volatile SingletonExample1 instance;

    /**
     * 私有构造器使得
     */
    private  SingletonExample1(){
        //do something whatever you like
    }

    /**
     * 创建并返回该类的唯一实例
     * 即只有该方法被调用的时候该类的唯一实例才会被创建
     */
    public static SingletonExample1 getInstance(){
        if(null == instance){
            synchronized (SingletonExample1.class){
                if(null == instance){
                    instance = new SingletonExample1();
                }
            }
        }
        return instance;
    }

    public void someService(){
        //do something whatever you like
    }
}
