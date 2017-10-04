package com.trustedshops.examples.javaDesignPatterns.command.commands;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

public class CopyCommand extends AbstractCommand {
    public CopyCommand(CommandOptions options) {
        super(options);
    }

    @Override
    public void doExecute(FileSystemApi api) {
        api.copy(getSource(), getTarget());
    }

    @Override
    public void doUndo(FileSystemApi api) {
        api.delete(getTarget());
    }
}
