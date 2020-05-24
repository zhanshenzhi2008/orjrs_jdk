package com.orjrs.jdk.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 线性列表实现LRU（Least Recently Used）
 *
 * @author orjrs
 * @create 2020-05-24 08:49
 * @since 1.0.0
 */
public class LinkedHashMapLru<K, V> {

    /** 双链表HashMap */
    private LinkedHashMap<K, V> linkedHashMap;

    /** map */
    private static final float THRSHOLD = 0.75f;

    /** 缓存大小 */
    private int cacheSize;


    public void LinkedLru(int cacheSize) {
        int capacity = (int) Math.ceil(cacheSize * THRSHOLD);
        linkedHashMap = new LinkedHashMap<K, V>(capacity, THRSHOLD, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LinkedHashMapLru.this.cacheSize;
            }

        };
    }
}
