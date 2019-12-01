package com.ll.jvm.classloader;

class  FinalTest{

    public static final int x = 3;

    static {
        System.out.println("Final Test Static Block !");
    }
}
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);  //3 意味着FinalTest并没有被初始化，编译器常量，在编译完之后就会放入线程池常量
    }
}
