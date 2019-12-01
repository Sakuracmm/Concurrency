package com.ll.jvm.classloader;

class Sington1{

    private static Sington1 sington = new Sington1();
    public static int counter1;
    public static int counter2 = 0;



    private Sington1(){      //构造方法
        counter1++;
        counter2++;
    }

    public static Sington1 getInstance(){
        return sington;
    }
}

public class ClassLoaderTest1 {

    public static void main(String[] args) {
        Sington1 sington = Sington1.getInstance();
        System.out.println("counter1 = " + Sington1.counter1);           //1
        System.out.println("counter2 = " + Sington1.counter2);           //0
    }
}
