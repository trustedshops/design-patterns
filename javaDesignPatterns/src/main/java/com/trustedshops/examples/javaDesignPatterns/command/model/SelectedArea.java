package com.trustedshops.examples.javaDesignPatterns.command.model;

public class SelectedArea {
    private final Position start;
    private final Position end;

    public SelectedArea(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }
}
