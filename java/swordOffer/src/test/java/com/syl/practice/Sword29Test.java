package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sword29Test {
    @Test
    public void isPopOrder() throws Exception {
        Sword29 s = new Sword29();
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        assertTrue(s.IsPopOrder(a,b));
    }

}