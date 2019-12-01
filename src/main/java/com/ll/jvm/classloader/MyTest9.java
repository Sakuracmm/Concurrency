package com.ll.jvm.classloader;

class Parent{
    static int a = 3;

    static{
        System.out.println("Parent static block !");
    }
}

class Child extends Parent{
    static int b = 4;

    static{
        System.out.println("Child static block !");
    }
}
public class MyTest9 {
    static {
        System.out.println("Mytest9 static block !");
    }

    public static void main(String[] args) {
        /**
         * Mytest9 static block !
         * Parent static block !
         * Child static block !
         * 4
         */
        System.out.println(Child.b);
    }
}
