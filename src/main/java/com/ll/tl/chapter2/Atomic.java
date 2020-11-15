package com.ll.tl.chapter2;

public class Atomic {
    private volatile static int counter = 0; // volatile 不保证原子性

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
//                    synchronized (Atomic.class) {
                        counter++;  // 这里不是原子操作
//                    }
                }
            }).start();
        }
        try{
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
