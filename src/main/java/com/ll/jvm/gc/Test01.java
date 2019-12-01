package com.ll.jvm.gc;

/**
 * 垃圾回收---判断是否为垃圾需要回收----引用计数法
 * 注意环境变量设置的
 * 参数-verbose:gc -XX:+PrintGCDetail用来打印出是垃圾回收信息
 */
public class Test01 {

    private Object instance;

    public Test01(){
        byte[] m = new byte[20 * 1024 * 1024];
    }

    public static void main(String[] args) {
        Test01 t1 = new Test01();
        Test01 t2 = new Test01();

        t1.instance = t2;
        t2.instance = t1;

        t1 = null;
        t2 = null;

        System.gc();

        //parallel  -> 垃圾回收器
    }
}
