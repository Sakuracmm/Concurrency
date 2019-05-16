package com.ll.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.ll.concurrency.annotations.ThreadSafe;

@ThreadSafe
public class ImmutableExample3 {
    private final static ImmutableList list = ImmutableList.of(1,2,3);
//    private final static List<Integer> list = ImmutableList.of(1,2,3);  也可以这样声明，但是可以使用add方法
    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map =
            ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map2 =
            ImmutableMap.<Integer,Integer>builder().put(1,2)
                                  .put(3,4)
                                  .put(5,6).build();

    public static void main(String[] args){
//        list.add(4);    //java.lang.UnsupportedOperationException
//        set.add(4);     //java.lang.UnsupportedOperationException
//
//        map.put(7,8);   //java.lang.UnsupportedOperationException
//        map2.put(7,8);  //java.lang.UnsupportedOperationException
        System.out.println(map.get(3));
    }
}
