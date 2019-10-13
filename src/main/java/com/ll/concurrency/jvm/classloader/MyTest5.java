package com.ll.concurrency.jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 其实在接口中定义的常量默认都是public static final 修饰的，也就是说直接放到了MyTest5的常量池中
 * 只有在真正使用到父接口的时候（如引用接口中所定义的常量的时候），才会初始化
 */
public class MyTest5 {

    public static void main(String[] args) {
//        System.out.println(MyChild5.b);       //输出对应线程
//        new C();
//        new C();
        System.out.println(Parent5_1.b); //输出b
    }
}

interface MyGrandpa{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyGrandpa invoked!");       //不输出
        }
    };
}

interface MyParent5 extends MyGrandpa{

    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked!");   //不输出
        }
    };

}

class MyChild5 implements MyParent5{

    public static int b = 3;

}

class C {

    //实例化块，每个C实例创建的时候都会先执行这个代码块（不管它书写的位置）
    // ，不像静态代码块只会执行一次
    {
        System.out.println("Hello");
    }
    public C(){
        System.out.println("C");
    }
    {
        System.out.println("World");
    }
}

interface Grandpa5_1{
    public static Thread thread = new Thread(){
        {
            System.out.println("Grandpa5_1 incoked!");      //不会输出，不执行初始化
        }
    };
}

interface Parent5_1 extends  Grandpa5_1{
    public static int b = new Random().nextInt(3);      //执行初始化
}
