package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CommandExecutorImpl implements CommandExecutor {

    private void processChain(Command root, Consumer<Command> consumer) {
        Command command = root;
        while (command != null) {
            consumer.accept(command);
            command = command.getSuccessor();
        }
    }

    private Command revertChain(Command root) {
        List<Command> reverted = new ArrayList<>();
        processChain(root, (cmd) -> reverted.add(0, cmd.newClone()));
        Command revertedRoot = reverted.get(0);
        reverted.subList(1, reverted.size()).stream().reduce(revertedRoot, Command::setSuccessor);
        return revertedRoot;
    }

    @Override
    public void execute(final FileSystemOperations fileSystemOperations, Command root) {
        processChain(root, (cmd) -> cmd.execute(fileSystemOperations));
    }

    @Override
    public void undo(FileSystemOperations fileSystemOperations, Command root) {
        Command revertedRoot = revertChain(root);
        processChain(revertedRoot, (cmd) -> cmd.undo(fileSystemOperations));
    }
}
