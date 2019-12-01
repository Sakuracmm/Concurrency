package com.ll.jvm.classloader;

/**
 * 对于数组实例来说，其类型是由jvm在运行期间动态生成的，不表示为[Lcom.ll.concurrency.jvm.classloader.MyParent4;
 * 形式，动态生成的类型，其父类型就是Object
 *
 * 对于数组来说，javaDoc经常将构成数组的元素为Component,实际上就是将数组降低一个维度后的类型
 * ，并不代表主动使用了数组中的引用类型的类
 *
 * 助记符：
 * anewarray： 表示创建一个引用类型的数组（如类，接口，数组）的数组，并把它的值压入栈顶
 * newarray: 表示创建一个指定的原始类型（如int,float,char等）的数组，并将其殷涌智压入栈顶
 */
public class MyTest4 {

    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();  //MyParent4 static block

        //MyParent4[] myParent4s = new MyParent4[1];  //不会输出任何内容，这行代码并不表示对类的主动使用
        //System.out.println(myParent4s.getClass());     //[Lcom.ll.concurrency.jvm.classloader.MyParent4,java虚拟机帮助我们在运行期创建出来的数组类型

//        MyParent4[][] myParent4s1 = new MyParent4[1][1];
//        System.out.println(myParent4s1.getClass());     //[[Lcom.ll.concurrency.jvm.classloader.MyParent4   二维数组
//        System.out.println(myParent4s1.getClass().getSuperclass()); //java.lang.Object
//
//        System.out.println("===================");
//
//        int[] ints = new int[1];
//        System.out.println(ints.getClass());        //[I
//        System.out.println(ints.getClass().getSuperclass());    // java.lang.Object
//
//        char[] chars = new char[1];
//        System.out.println(chars.getClass());   //[C
//        System.out.println(chars.getClass().getSuperclass());   //java.lang.Object
//
//        boolean[] booleans = new boolean[1];
//        System.out.println(booleans.getClass());    //[Z
//        System.out.println(booleans.getClass().getSuperclass());    //java.lang.Object
//
//        short[] shorts = new short[1];
//        System.out.println(shorts.getClass());  //[S
//        System.out.println(shorts.getClass().getSuperclass());  //java.lang.Objecy
//
//        byte[] bytes = new byte[1];
//        System.out.println(bytes.getClass());   //[B
//        System.out.println(bytes.getClass().getSuperclass());       //java.lang.Object

//        System.out.println(Cat.married);        //不会执行静态代码块
//        System.out.println(Cat.girlfriend);     //不会执行静态代码块
//        System.out.println(Cat.eat);    //不会执行静态代码块
    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}

class Cat{
    public static final String name = "Tom";
    public static final String soul = "Alice";
    public static final String married = name + soul;
    public static final String girlfriend = soul;
    public static final String eat = name + "eat";

    static {
        System.out.println("Cat static code");
    }
}