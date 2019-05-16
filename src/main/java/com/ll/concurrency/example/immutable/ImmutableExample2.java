package com.ll.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.ll.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {
    private static Map<Integer,Integer> map = Maps.newHashMap();    //没有final关键字

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);     //将对象变为内容不可变的，修改值时会抛出异常
    }

    public static void main(String[] args) {
        map.put(1,3);       //抛出异常java.lang.UnsupportedOperationException，线程安全，数据不会被污染
        log.info("{}",map.get(1));
        map = Maps.newHashMap();    // √
    }

}
