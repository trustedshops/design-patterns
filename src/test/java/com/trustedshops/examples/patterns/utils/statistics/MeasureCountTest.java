package com.trustedshops.examples.patterns.utils.statistics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeasureCountTest {
    @Test
    public void increase() {
        MeasureCount mc = new MeasureCount();
        assertEquals(0L, mc.getValue());
        mc.increase();
        assertEquals(1L, mc.getValue());
        mc.increaseWith(800);
        assertEquals(801L, mc.getValue());
    }
}

