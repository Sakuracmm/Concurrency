package com.ll.concurrency.example.singleton;

import com.ll.concurrency.annotations.NotThreadSafe;

/**
  * 懒汉模式        --》双重同步锁单例模式
  * 单例的创建在第一次使用时创建
  *
  */
@NotThreadSafe
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4(){

    }
    //单例对象
    private static SingletonExample4 instance = null;

    //1、memory = allocate() 分配堆内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance执向刚刚分配的内存

    //JVM和CPU优化，发生了指令重排，如下所示，AB进程同时调用静态方法，且A执行到代码39行，B执行到36行，
    // A在CPU层面上按照1=》3=》2执行到步骤2，这个时候B线程误以为对象已经被初始化直接返回一个instance造成
    // 了不安全对象发布（概率不大）

    //1、memory = allocate() 分配堆内存空间
    //3、instance = memory 设置instance执向刚刚分配的内存
    //2、ctorInstance() 初始化对象

    //静态的工厂方法
    public static SingletonExample4 getInstance(){

        if(instance == null){   //双重检测机制        B 线程
            synchronized (SingletonExample4.class) {        //同步锁
                if(instance == null) {
                    instance = new SingletonExample4();     //A 线程 --》3
                }
            }
        }
        return instance;
    }


}
