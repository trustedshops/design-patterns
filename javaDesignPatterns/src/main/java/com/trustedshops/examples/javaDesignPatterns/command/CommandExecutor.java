package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;

public interface CommandExecutor {
    void execute(FileSystemOperations fileSystemOperations, Command root);
    void undo(FileSystemOperations fileSystemOperations, Command root);

}
