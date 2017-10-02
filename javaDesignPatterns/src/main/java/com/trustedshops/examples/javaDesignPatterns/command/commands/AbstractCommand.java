package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.Command;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

abstract class AbstractCommand implements Command {
    private final CommandOptions options;
    private Command successor;

    AbstractCommand(CommandOptions options) {
        this.options = options;
    }

    protected CommandOptions getOptions() {
        return options;
    }

    public Command getSuccessor() {
        return successor;
    }

    public void setSuccessor(Command successor) {
        this.successor = successor;
    }

    public String getSource() {
        return getOptions().getSource();
    }

    public String getTarget() {
        return getOptions().getTarget();
    }
}
