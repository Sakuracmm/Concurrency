package com.ll.concurrency.example.singleton;

import com.ll.concurrency.annotations.ThreadSafe;

/**
  * 饿汉模式
  * 单例的创建在类装载时创建
  * 但是在类加载的时候如果类中加载的数据特别多，
  * 需要很多的操作会造成性能降低问题
  * 而且如果这个类只加载而不使用的话会造成资源的浪费
  */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }


}
