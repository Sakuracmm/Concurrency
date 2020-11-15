package com.ll.tl.chapter2;

import com.ll.tl.util.UnsafeInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reorder {

    private static final Logger LOG = LoggerFactory.getLogger(Reorder.class);
    private static int x = 0, y = 0;
//    private volatile static int x = 0, y = 0;
    private static int a = 0, b = 0;
//    private volatile static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            Thread t1 = new Thread(() -> {
//                try {
//                    shortWait(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                a = 1;
                UnsafeInstance.reflectGetUnsafe().fullFence();
                x = b;
            });

            Thread t2 = new Thread(() -> {
                b = 1;
                UnsafeInstance.reflectGetUnsafe().fullFence();
                y = a;
            });


            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String result = "第" + i + "次 (" + x + "," + y + ")";
            if (x == 0 && y == 0) {     // 发生了指令重排
                System.out.println(result);
                break;
            } else {
                LOG.info("{}", result);
            }
        }
    }

    private static void shortWait(long interval) throws InterruptedException {
        Thread.sleep(interval);
    }

}
