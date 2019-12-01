package com.ll.jvm.classloader;

class CL {
    static {
        System.out.println("Class CL");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * class com.ll.jvm.classloader.CL
         * ----------
         * Class CL
         * class com.ll.jvm.classloader.CL
         */
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.ll.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("----------");
        clazz = Class.forName("com.ll.jvm.classloader.CL");
        System.out.println(clazz);
    }
}
