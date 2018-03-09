package com.syl.junit;

import com.syl.util.PropertiesUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesUtilTest {
    @Test
    public void getProperty() throws Exception {
        assertEquals("test", PropertiesUtil.getProperty("test"));
    }

}