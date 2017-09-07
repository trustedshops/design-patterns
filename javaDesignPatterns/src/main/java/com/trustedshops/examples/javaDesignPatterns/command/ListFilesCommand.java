package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.utils.io.Directorys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ListFilesCommand implements Command {

    @Override
    public void execute(List<String> commandArgs, Map<String, Collection<String>> commandOptions) {
        if(commandArgs.size() == 0) {
            throw new IllegalArgumentException("path argument is missing!");
        }
        Directorys.traverse(commandArgs, System.out::println);
    }
}
