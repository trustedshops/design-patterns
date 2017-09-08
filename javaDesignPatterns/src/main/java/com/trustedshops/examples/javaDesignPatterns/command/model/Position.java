package com.trustedshops.examples.javaDesignPatterns.command.model;

public class Position {
    private final long row;
    private final long column;

    public Position(long row, long column) {
        this.row = row;
        this.column = column;
    }

    public long getRow() {
        return row;
    }

    public long getColumn() {
        return column;
    }
}
