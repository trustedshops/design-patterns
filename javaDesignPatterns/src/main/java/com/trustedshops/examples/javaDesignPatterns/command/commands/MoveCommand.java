package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

public class MoveCommand extends AbstractCommand {
    private final CommandOptions options;
    public MoveCommand(CommandOptions options) {
        this.options = options;
    }

    @Override
    public void doExecute(FileSystemApi api) {
        api.move(options.getSource(), options.getTarget());
    }

    @Override
    public void doUndo(FileSystemApi api) {
        api.move(options.getTarget(), options.getSource());
    }
}
