package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemApi;

public interface CommandExecutor {
    void execute(FileSystemApi api, Command root);
    void undo(FileSystemApi api, Command root);

}
