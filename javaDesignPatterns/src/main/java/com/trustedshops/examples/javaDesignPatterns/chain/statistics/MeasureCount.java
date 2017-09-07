package com.trustedshops.examples.javaDesignPatterns.chain.statistics;

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
}
