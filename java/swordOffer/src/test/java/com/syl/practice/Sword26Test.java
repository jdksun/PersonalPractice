package com.syl.practice;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Sword26Test {
    @Test
    public void findNumbersWithSum() throws Exception {
        Sword26 s = new Sword26();
        int a[] = {1,2,4,7,11,15};
        ArrayList<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(11);
        assertEquals(l,s.FindNumbersWithSum(a,15));
    }

}