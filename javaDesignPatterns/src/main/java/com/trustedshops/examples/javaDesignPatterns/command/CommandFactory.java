package com.trustedshops.examples.javaDesignPatterns.command;

import java.util.Optional;

public interface CommandFactory {
    Command create(String name) throws CommandNotFoundException;
}
