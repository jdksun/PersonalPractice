package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sword11Test {
    @Test
    public void findGreatestSumOfSubArray() throws Exception {
        int[] a = {1,-2,3,10,-4,7,2,-5};

        Sword11 c = new Sword11();
        assertEquals(18,new Sword11().FindGreatestSumOfSubArray(a));
    }

}