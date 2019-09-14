package com.ll.concurrency.jvm.classloader;

class Sington2{


    public static int counter1;
    public static int counter2 = 0;
    private static Sington2 sington = new Sington2();

    private Sington2(){      //构造方法
        counter1++;
        counter2++;
    }

    public static Sington2 getInstance(){
        return sington;
    }
}

public class ClassLoaderTest2 {

    public static void main(String[] args) {
        Sington2 sington = Sington2.getInstance();
        System.out.println("counter1 = " + Sington2.counter1);           //1
        System.out.println("counter2 = " + Sington2.counter2);           //1
    }
}
