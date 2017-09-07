package com.trustedshops.examples.javaDesignPatterns.utils.statistics;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class MeasureGroupTest {
    @Test
    public void add() {
        MeasureGroup mg = new MeasureGroup();
        assertEquals(Collections.emptyList(), mg.getKeys());

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
