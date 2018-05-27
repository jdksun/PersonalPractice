package com.syl.xq;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void test(){
        T1 t1 = new T1();
        int[] a = {1,2,3};
        assertEquals(T1.Triangle.非三角形,t1.judge(a));
        int[] b = {3,4,5};
        assertEquals(T1.Triangle.直角三角形,t1.judge(b));
        int[] c = {3,3,5};
        assertEquals(T1.Triangle.等腰三角形,t1.judge(c));
        int[] d = {3,3,3};
        assertEquals(T1.Triangle.等边三角形,t1.judge(d));
        int[] e = {6,9,10};
        assertEquals(T1.Triangle.一般三角形,t1.judge(e));
    }
}