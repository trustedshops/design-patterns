package com.trustedshops.examples.javaDesignPatterns.command;

public interface CommandParser {
    Command parse(String... lines);
}
