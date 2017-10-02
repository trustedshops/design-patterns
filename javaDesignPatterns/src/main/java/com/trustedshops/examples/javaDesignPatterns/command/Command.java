package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute();
    void revert();
}
