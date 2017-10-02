package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

public class CopyCommand extends AbstractCommand {
    public CopyCommand(CommandOptions options) {
        super(options);
    }

    @Override
    public void execute(FileSystemOperations fileSystemOperations) {
        fileSystemOperations.copy(getSource(), getTarget());
    }

    @Override
    public void undo(FileSystemOperations fileSystemOperations) {
        fileSystemOperations.delete(getTarget());
    }
}
