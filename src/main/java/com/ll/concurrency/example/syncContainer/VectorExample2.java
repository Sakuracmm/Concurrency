package com.ll.concurrency.example.syncContainer;

import com.ll.concurrency.annotations.NotThreadSafe;

import java.util.Vector;

@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    //java.lang.ArrayIndexOutOfBoundsException: Array index out of range
    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }
    }
}
