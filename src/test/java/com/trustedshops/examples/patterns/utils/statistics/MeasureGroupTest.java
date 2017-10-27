package com.trustedshops.examples.patterns.utils.statistics;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasureGroupTest {
    @Test
    public void add() {
        MeasureGroup mg = new MeasureGroup();
        assertEquals(Collections.emptyList(), mg.getKeys());
        assertEquals(0L, mg.getCount("a"));

        mg.add("a");
        assertEquals(Collections.singletonList("a"), mg.getKeys());
        assertEquals(1L, mg.getCount("a"));

        mg.add("a");
        assertEquals(2L, mg.getCount("a"));

        mg.add("b");
        assertEquals(Arrays.asList("a", "b"), mg.getKeys());
        assertEquals(1L, mg.getCount("b"));
    }
}
