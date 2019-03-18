package com.ll.concurrency.singleton;

import com.ll.concurrency.annotations.ThreadSafe;

/**
  * 饿汉模式
  * 单例的创建在类装载时创建
  * 但是在类加载的时候如果类中加载的数据特别多，
  * 需要很多的操作会造成性能降低问题
  * 而且如果这个类只加载而不使用的话会造成资源的浪费
  */
@ThreadSafe
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){

    }
    //单例对象 ---> 一定要先创建这个类的对象
    private static SingletonExample6 instance = null;
    //使用静态块来进行对象初始化 --->再初始化对象，否则会出现空指针
    static{
        instance = new SingletonExample6();
    }



    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }


}
