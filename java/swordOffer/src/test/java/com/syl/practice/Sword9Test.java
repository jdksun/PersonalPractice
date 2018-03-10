package com.syl.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sword9Test {
    @Test
    public void jumpFloor() throws Exception {
        assertEquals(1,new Sword9().JumpFloor(1));
        assertEquals(2,new Sword9().JumpFloor(2));
        assertEquals(3,new Sword9().JumpFloor(3));
        assertEquals(5,new Sword9().JumpFloor(4));
    }

    @Test
    public void jumpFloor2() throws Exception {
        assertEquals(1,new Sword9().JumpFloor2(1));
        assertEquals(2,new Sword9().JumpFloor2(2));
        assertEquals(3,new Sword9().JumpFloor2(3));
        assertEquals(5,new Sword9().JumpFloor2(4));
    }

}