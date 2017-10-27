package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.commands.CommandChain;

public interface CommandParser {
    CommandChain parse(String... lines);
}
