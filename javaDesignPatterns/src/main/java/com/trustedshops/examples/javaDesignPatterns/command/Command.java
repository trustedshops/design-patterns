package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(FileSystemOperations fileSystemOperations);
    void undo(FileSystemOperations fileSystemOperations);
    Command getSuccessor();
    Command setSuccessor(Command command);
    Command newClone();
}
