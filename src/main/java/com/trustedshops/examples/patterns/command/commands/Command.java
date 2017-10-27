package com.trustedshops.examples.patterns.command.commands;

import com.trustedshops.examples.patterns.command.io.FileSystemApi;

import java.io.Serializable;

public interface Command extends Serializable {
    void execute(FileSystemApi api);

    void undo(FileSystemApi api);

    Command getSuccessor();

    void setSuccessor(Command command);

    Command getAncestor();

    void setAncestor(Command ancestor);

    default boolean hasSuccessor() {
        return getSuccessor() != null;
    }

    default boolean hasAncestor() {
        return getAncestor() != null;
    }
}
