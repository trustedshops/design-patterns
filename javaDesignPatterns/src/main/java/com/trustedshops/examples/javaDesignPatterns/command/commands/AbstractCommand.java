package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.Command;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

abstract class AbstractCommand implements Command {
    private final CommandOptions options;
    private Command successor;
    private Command ancestor;

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
        successor.setAncestor(this);
    }

    public Command getAncestor() {
        return ancestor;
    }

    public void setAncestor(Command ancestor) {
        this.ancestor = ancestor;
    }

    public String getSource() {
        return getOptions().getSource();
    }

    public String getTarget() {
        return getOptions().getTarget();
    }
}
