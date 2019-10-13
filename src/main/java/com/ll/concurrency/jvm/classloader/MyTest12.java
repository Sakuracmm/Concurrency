package com.ll.concurrency.jvm.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * class com.ll.concurrency.jvm.classloader.CL
         * ----------
         * Class CL
         * class com.ll.concurrency.jvm.classloader.CL
         */
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.ll.concurrency.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("----------");
        clazz = Class.forName("com.ll.concurrency.jvm.classloader.CL");
        System.out.println(clazz);
    }
}
