package com.ll.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {


    //修饰一个类
    private static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for(int i = 0;i < 10; i++){
                log.info("test 1 - {} - {}", i,j);
            }
        }
    }


    //修饰一个静态方法
    public static synchronized void test2(int j){
        for(int i = 0 ; i < 10; i++){
            log.info("test 2  - {} - {}", i, j);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        //申请线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test1(1);
        });
        executorService.execute(()->{
            example2.test1(2);
        });
    }
}
