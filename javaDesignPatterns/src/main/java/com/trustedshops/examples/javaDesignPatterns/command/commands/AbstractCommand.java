package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.Command;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

abstract class AbstractCommand implements Command {
    private final CommandOptions options;


    AbstractCommand(CommandOptions options) {
        this.options = options;
    }

    protected CommandOptions getOptions() {
        return options;
    }
}
