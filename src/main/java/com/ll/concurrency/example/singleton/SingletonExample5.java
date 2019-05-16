package com.ll.concurrency.example.singleton;

import com.ll.concurrency.annotations.ThreadSafe;

/**
  * 懒汉模式        --》双重同步锁单例模式
  * 单例的创建在第一次使用时创建
  *
  */
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){

    }
    //单例对象 ==>使用volatile关键字限制指令重排 volatile指令的使用场景（1、标记量；2、双重检测机制）
    //volatile+双重监测机制来避免指令重排
    private volatile static SingletonExample5 instance = null;

    //1、memory = allocate() 分配堆内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance执向刚刚分配的内存

    //静态的工厂方法
    public static SingletonExample5 getInstance(){

        if(instance == null){   //双重检测机制
            synchronized (SingletonExample5.class) {        //同步锁
                if(instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }


}
