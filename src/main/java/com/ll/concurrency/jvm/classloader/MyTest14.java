package com.ll.concurrency.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {

    public static void main(String[] args) throws IOException {
        //返回当前线程的上下文类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);    //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        String resourceName = "com/ll/concurrency/jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        //file:/D:/ideaProject/Concurrency/target/classes/com/ll/concurrency/jvm/classloader/MyTest13.class
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("-----------");

        Class<?> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d

        Class<?> clazz2 = String.class;
        System.out.println(clazz2.getClassLoader()); //null
    }
}
