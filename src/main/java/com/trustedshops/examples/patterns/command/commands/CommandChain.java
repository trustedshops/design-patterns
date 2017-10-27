package com.trustedshops.examples.patterns.command.commands;

import com.trustedshops.examples.patterns.command.io.FileSystemApi;

public class CommandChain extends AbstractCommand {
    private final Command first;
    private final Command last;

    public CommandChain(Command first, Command last) {
        this.first = first;
        this.last = last;
    }

    public void doExecute(FileSystemApi api) {
        first.execute(api);
    }

    public void doUndo(FileSystemApi api) {
        last.undo(api);
    }
}
