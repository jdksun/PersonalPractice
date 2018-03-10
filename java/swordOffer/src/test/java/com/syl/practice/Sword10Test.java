package com.syl.practice;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sword10Test {
    @Test
    public void rectCover() throws Exception {

        Assert.assertEquals(1,new Sword10().RectCover(1));
        assertEquals(2,new Sword10().RectCover(2));
        assertEquals(3,new Sword10().RectCover(3));
        assertEquals(5,new Sword10().RectCover(4));
    }

}