package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

public class MoveCommand extends AbstractCommand {
    public MoveCommand(CommandOptions options) {
        super(options);
    }

    @Override
    public void execute(FileSystemOperations fileSystemOperations) {
        fileSystemOperations.move(getSource(), getTarget());
    }

    @Override
    public void undo(FileSystemOperations fileSystemOperations) {
        fileSystemOperations.move(getTarget(), getSource());
    }
}
