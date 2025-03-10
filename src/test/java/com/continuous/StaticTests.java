package com.continuous;

import com.continuous.practice.utils.StaticClass;
import org.junit.Assert;
import org.junit.Test;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(StaticClass.class)
public class StaticTests {

    private StaticClass staticClass;

    @Test
    public void testStatic() {
        System.out.println("sda");
        Assert.assertEquals("hari", StaticClass.staticMethod("hari"));
    }
}
