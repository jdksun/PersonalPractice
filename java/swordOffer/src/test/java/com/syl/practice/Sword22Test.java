package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sword22Test {
    @Test
    public void lastRemaining_Solution() throws Exception {
        Sword22 s = new Sword22();
        assertEquals(3,s.LastRemaining_Solution(5,3));
        assertEquals(3,s.LastRemaining_Solution3(5,3));
    }

}