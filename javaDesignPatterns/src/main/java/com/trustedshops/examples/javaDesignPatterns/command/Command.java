package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(FileSystemApi api);
    void undo(FileSystemApi api);
    Command getSuccessor();
    void setSuccessor(Command command);
    Command getAncestor();
    void setAncestor(Command ancestor);
}
