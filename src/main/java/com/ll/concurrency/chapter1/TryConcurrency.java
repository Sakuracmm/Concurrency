package com.ll.concurrency.chapter1;

public class TryConcurrency {

    private static void readFromDB(){
        //read data from database and handle it
        try{
            println("Begin read data from db.");
            Thread.sleep(1000 * 30L);
            println("read data done and start handle it.");
        }catch (Exception e){
            e.printStackTrace();
        }

        println("The data handle finished and successfully");
    }

    private static void writeDataToFile(){
        //read data from database and handle it
        try{
            println("Begin write data to file.");
            Thread.sleep(1000 * 30L);
            println("write data done and start handle it.");
        }catch (Exception e){
            e.printStackTrace();
        }

        println("The data handle finished and successfully");
    }

    private static void println(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
//        readFromDB();
//        writeDataToFile();
//        for(int j = 0; j < 100; j++){
//            println("Task j => " + j);
//        }
//        try{
//            Thread.sleep(1000 * 300L);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        Thread t1 = new Thread("Custom-Thread"){
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++){
//                    println("Task 2 => " + i);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//
//        t1.start();
//
//        for(int i = 0; i < 1000; i++){
//            println("Task 1 => " + i);
//        }

        new Thread("READ-Thread"){
            @Override
            public void run() {
                readFromDB();
            }
        }.start();

        new Thread("WRITE-Thread"){
            @Override
            public void run() {
                readFromDB();
            }
        }.start();

    }

}
