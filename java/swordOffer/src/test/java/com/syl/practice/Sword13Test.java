package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sword13Test {
    @Test
    public void numberOf1Between1AndN_Solution() throws Exception {
        Sword13 s = new Sword13();
        assertEquals(6,s.NumberOf1Between1AndN_Solution(13));
        assertEquals(6,s.NumberOf1Between1AndN_Solution3(13));
    }

}