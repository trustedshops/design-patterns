package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;

public class CommandExecutorImpl implements CommandExecutor {

    private Command lastCommand(Command root) {
        Command command = root;
        Command last = root;
        while (command != null) {
            command = command.getSuccessor();
            if(command != null) {
                last = command;
            }
        }
        return last;
    }

    @Override
    public void execute(final FileSystemApi api, Command root) {
        root.execute(api);
    }

    @Override
    public void undo(FileSystemApi api, Command root) {
        lastCommand(root).undo(api);
    }
}
