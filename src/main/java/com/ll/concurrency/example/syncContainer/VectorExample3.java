package com.ll.concurrency.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

/**
 * 说明不管在单线程还是多线程中在使用foreach或是迭代器遍历集合的时候尽量不要做remove等相关的
 * 修改操作，否则会抛出异常，如果一定要修改时，建议先标记该元素，在遍历完之后再进行修改操作或
 * 者使用简单的for循环，再多线程的时候可以使用synchronize关键字或是并发容器。
 */
public class VectorExample3 {

    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1){  //foreach
        for (Integer i :
                v1) {
            if (i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1){     //iteratior
        Iterator<Integer> integerIterator = v1.iterator();
        while(integerIterator.hasNext()){
            Integer i = integerIterator.next();
            if(i.equals(3)){
                v1.remove(i);
            }
        }
    }

    //success
    private static void test3(Vector<Integer> v1){
        for (int i = 0; i < v1.size(); i++){
            if(v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        test3(vector);

    }

}
