package com.ll.concurrency.jvm.classloader;

public class MyTest13 {
    public static void main(String[] args) {
        /**
         * jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
         * ------------
         * jdk.internal.loader.ClassLoaders$PlatformClassLoader@306a30c7
         * null
         */
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        System.out.println("------------");
        while (null != classLoader){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}
