package com.ll.concurrency.jvm.classloader;

/**
 * 关于类加载器
 */
public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());     //null 说明使用的是启动类加载的该class

        Class<?> clazz2 = Class.forName("com.ll.concurrency.jvm.classloader.D");
        System.out.println(clazz2.getClassLoader());    //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d  系统类加载
    }
}

class D{

}
