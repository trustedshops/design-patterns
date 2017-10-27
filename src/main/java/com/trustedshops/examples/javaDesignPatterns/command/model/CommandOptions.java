package com.trustedshops.examples.javaDesignPatterns.command.model;

import java.io.Serializable;

public class CommandOptions implements Serializable {
    private final String source;
    private final String target;

    public CommandOptions(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }
}
