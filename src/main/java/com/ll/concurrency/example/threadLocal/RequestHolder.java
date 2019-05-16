package com.ll.concurrency.example.threadLocal;

public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    //请求进入到后台服务器但是在实际处理之前的时候
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    //实际处理完之后进行处理
    public static void remove(){
        requestHolder.remove();
    }

}
