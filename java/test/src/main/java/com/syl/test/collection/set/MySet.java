package com.syl.test.collection.set;

import java.sql.DriverManager;
import java.util.*;

public class MySet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet();
        set.add(1);
        Class c = set.getClass();
        System.out.println(c.toString());;
    }
}
