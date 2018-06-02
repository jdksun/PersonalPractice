package com.syl.thread.test;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Test5 {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("aa", 111);
        ha("aa".hashCode());
    }
    public static void ha(int h){
       int n = (h ^ (h >>> 16)) & 0x7ffffff;
        System.out.println(n);
    }

    }

final class Three{
    private final Set<String> set = new HashSet<String>();

    public Three() {
        set.add("a");
        set.add("b");
        set.add("c");

    }

    public boolean isThree(String name){
        return set.contains(name);
    }
}