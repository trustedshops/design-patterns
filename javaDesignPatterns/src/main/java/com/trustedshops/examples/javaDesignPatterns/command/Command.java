package com.trustedshops.examples.javaDesignPatterns.command;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Command {
    void execute(List<String> commandArgs, Map<String, Collection<String>> commandOptions);
}
