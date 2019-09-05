package com.ll.myjvm.myloader;

/**
 * @author LL
 * @date 2019/9/5
 * @description jvm 类加载器
 */
public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader); //sun.misc.Launcher$AppClassLoader@18b4aac2
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader.loadClass("Test");
        //使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("Test");
        //使用Class.forName()来加载类。并指定ClassLoader.初始化时不指行静态代码块
        Class.forName("Test",false,loader);
    }

}
