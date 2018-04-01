package com.syl.test.oujilide;

import org.junit.Test;

import static org.junit.Assert.*;

public class OuJiLiDeTest {
    @Test
    public void gcd() throws Exception {
        OuJiLiDe o = new OuJiLiDe();
        assertEquals(5,o.gcd(5,15));
    }


}