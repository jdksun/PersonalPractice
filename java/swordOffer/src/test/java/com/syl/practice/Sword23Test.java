package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class Sword23Test {
    @Test
    public void leftRotateString() throws Exception {
        Sword23 s = new Sword23();
        assertEquals("cdefgab",s.LeftRotateString("abcdefg",2));
        assertEquals("gabcdef",s.LeftRotateString3("abcdefg",6));
    }

    @Test
    public void leftRotateString2() throws Exception {
        Sword23 s = new Sword23();
        assertEquals("cdefgab",s.LeftRotateString2("abcdefg",2));
        assertEquals("gabcdef",s.LeftRotateString2("abcdefg",6));
    }

}