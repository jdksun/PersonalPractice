package com.syl.design;

import java.util.Hashtable;
import java.util.Iterator;

public class A {
    public static void main(String[] args) {
        Hashtable<String,String> h = new Hashtable<String, String>();
        h.put("11","v11");
        h.put("22","v22");
        h.put("33","v33");
        h.put("44","v44");
        h.put("55","v55");
        Iterator<String> iterator = h.values().iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
    }
}
