package com.syl.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class O1Test {

    @Test
    public void lengthOfLongestSubstring() {
        O1 o = new O1();
        System.out.println(o.lengthOfLongestSubstring("aaabbvvcaa"));
    }

    @Test
    public void lengthOfLongestSubstring2() {
        O1 o = new O1();
        System.out.println(o.lengthOfLongestSubstring2(" "));
        System.out.println(o.lengthOfLongestSubstring2("abcdeafghigk"));
    }
    @Test
    public void lengthOfLongestSubstring3() {
        O1 o = new O1();
        System.out.println(o.lengthOfLongestSubstring3("abcabcdabcde"));
    }
}