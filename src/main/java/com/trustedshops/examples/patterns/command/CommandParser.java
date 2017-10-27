package com.trustedshops.examples.patterns.command;

import com.trustedshops.examples.patterns.command.commands.CommandChain;

public interface CommandParser {
    CommandChain parse(String... lines);
}
