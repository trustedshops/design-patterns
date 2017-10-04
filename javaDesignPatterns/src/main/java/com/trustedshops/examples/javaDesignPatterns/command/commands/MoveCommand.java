package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

public class MoveCommand extends AbstractCommand {
    public MoveCommand(CommandOptions options) {
        super(options);
    }

    @Override
    public void doExecute(FileSystemApi api) {
        api.move(getSource(), getTarget());
    }

    @Override
    public void doUndo(FileSystemApi api) {
        api.move(getTarget(), getSource());
    }
}
