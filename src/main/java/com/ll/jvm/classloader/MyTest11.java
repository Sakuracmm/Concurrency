package com.ll.jvm.classloader;

//通过子类的类名调用父类的静态变量或者静态方法表示的是对父类的主动使用
class Parent3 {
    static int a = 3;
    static{
        System.out.println("Parent3 static block !");
    }
    static void doSomething(){
        System.out.println("do something !");
    }
}
class Child3 extends Parent3{
    static{
        System.out.println("Child3 static block !");
    }
}

public class MyTest11{
    public static void main(String[] args) {
        /**
         * Parent3 static block !
         * 3
         * ------
         * do something !
         */
        System.out.println(Child3.a);
        System.out.println("------");
        Child3.doSomething();
    }
}