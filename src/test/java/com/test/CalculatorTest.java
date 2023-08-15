package com.test;

import com.test.practice.multiThreading.MathUtil;
import com.test.practice.utils.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MathUtil.class)
public class CalculatorTest {

    /**
     * Unit under test.
     */
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();

        PowerMockito.mockStatic(MathUtil.class);
        PowerMockito.when(MathUtil.addInteger(1, 1)).thenReturn(0);
    }

    @Test
    public void shouldCalculateInAStrangeWay() {
        Assert.assertEquals(2, calc.add(1, 1));
    }
}