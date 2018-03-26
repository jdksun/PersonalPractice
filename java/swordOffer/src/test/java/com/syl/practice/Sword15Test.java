package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sword15Test {
    @Test
    public void test() throws Exception {

        Sword15 s = new Sword15();
        for (int i=1;i<10;i++)
            s.push(i);
        assertEquals(9,s.top());
        assertEquals(1,s.min());
    }

}