package com.ll.concurrency.jvm.classloader;

public class MyTest2{
    public static void main(String[] args){
        System.out.println(MyParent2.str);
    }
}


public class MyParent2 {
    public static String str = "hello world";
    static{
        System.out.println("MyParent2 static block");
    }
}
