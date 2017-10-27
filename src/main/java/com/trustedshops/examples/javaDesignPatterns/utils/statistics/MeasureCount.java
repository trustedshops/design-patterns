package com.trustedshops.examples.javaDesignPatterns.utils.statistics;

public class MeasureCount {
    private long value;

    public long increase() {
        value += 1;
        return value;
    }

    public long increaseWith(long amount) {
        value += amount;
        return value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MeasureCount{" +
                "value=" + value +
                '}';
    }
}
