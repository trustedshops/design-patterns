package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

public class CopyCommand extends AbstractCommand {
    private final CommandOptions options;
    public CopyCommand(CommandOptions options) {
        this.options = options;
    }

    @Override
    public void doExecute(FileSystemApi api) {
        api.copy(options.getSource(), options.getTarget());
    }

    @Override
    public void doUndo(FileSystemApi api) {
        api.delete(options.getTarget());
    }
}
