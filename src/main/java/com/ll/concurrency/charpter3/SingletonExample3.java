package com.ll.concurrency.charpter3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于枚举类型的单例模式实现代码
 */
public class SingletonExample3 {

    private static Logger logger = LoggerFactory.getLogger(SingletonExample3.class);

    public static void main(String[] args){
        Thread t = new Thread(){
            @Override
            public void run() {
                logger.info(SingletonExample3.class.getName());
                Singleton.INSTANCE.someService();
            }
        };
        t.start();
    }
    
    
    public static enum Singleton{
        INSTANCE;
        //私有构造器
        Singleton(){
            logger.info("Singleton inited.");
        }

        public void someService(){
            logger.info("sometService invoked!");
            //do something you like
        }
    }
}
