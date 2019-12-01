package com.ll.jvm.classloader;

/**
 * 对于静态字段来说，只有定义了该字段的了才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕
 * -XX:+TraceClassLoading,用于追踪类的加载信息并且打印出来
 * -XX:+<option>,表示开启option选项
 * -XX:-<option>,表示关闭option选项
 * -XX:<option>=<value>,表示将option选项的值设置为value
 *
 */
public class MyTest01 {
    public static void main(String[] args) {
        /*
         * my parent1 static block
         * hello world
         */
//        System.out.println(MyChild.str);
        /*
         * my parent1 static block
         * MyChild1 static block
         * welcome
         */
        System.out.println(MyChild.str2);
    }
}
class MyParent1{
    public static String str = "hello world";;
    static{
        System.out.println("my parent1 static block");
    }
}

class MyChild extends MyParent1{
    public static String str2 = "welcome";
    static{
        System.out.println("MyChild1 static block");
    }
}
