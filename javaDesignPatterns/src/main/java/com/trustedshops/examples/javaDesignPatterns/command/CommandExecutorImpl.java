package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;

import java.util.function.Consumer;

public class CommandExecutorImpl implements CommandExecutor {

    private void processChain(Command root, Consumer<Command> consumer) {
        Command command = root;
        while (command != null) {
            consumer.accept(command);
            command = command.getSuccessor();
        }
    }

    @Override
    public void execute(final FileSystemOperations fileSystemOperations, Command root) {
        processChain(root, (cmd) -> cmd.execute(fileSystemOperations));
    }

    @Override
    public void undo(FileSystemOperations fileSystemOperations, Command root) {
        processChain(root, (cmd) -> cmd.undo(fileSystemOperations));
    }
}
