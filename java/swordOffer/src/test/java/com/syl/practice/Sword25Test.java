package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sword25Test {
    @Test
    public void getNumberOfK() throws Exception {
        Sword25 s = new Sword25();
        int[] a = {1,2,3,3,3,3,4,5};
        assertEquals(4,s.GetNumberOfK(a,3));
    }

}