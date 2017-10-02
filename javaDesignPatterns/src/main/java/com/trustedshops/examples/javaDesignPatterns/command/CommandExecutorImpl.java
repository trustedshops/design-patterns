package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;

import java.util.function.Consumer;

public class CommandExecutorImpl implements CommandExecutor {

    private Command processForwards(Command root, Consumer<Command> consumer) {
        Command command = root;
        Command last = root;
        while (command != null) {
            consumer.accept(command);
            command = command.getSuccessor();
            if(command != null) {
                last = command;
            }
        }
        return last;
    }

    private Command lastCommand(Command root) {
        return processForwards(root, (cmd) -> {});
    }

    private void processBackwads(Command root, Consumer<Command> consumer) {
        Command command = lastCommand(root);
        while (command != null) {
            consumer.accept(command);
            command = command.getAncestor();
        }
    }

    @Override
    public void execute(final FileSystemOperations fileSystemOperations, Command root) {
        processForwards(root, (cmd) -> cmd.execute(fileSystemOperations));
    }

    @Override
    public void undo(FileSystemOperations fileSystemOperations, Command root) {
        processBackwads(root, (cmd) -> cmd.undo(fileSystemOperations));
    }
}
