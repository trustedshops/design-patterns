package com.trustedshops.examples.javaDesignPatterns.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ListFilesCommand implements Command {

    @Override
    public void execute(List<String> commandArgs, Map<String, Collection<String>> commandOptions) {
        if(commandArgs.size() == 0) {
            throw new IllegalArgumentException("path argument is missing!");
        }
        File root = new File(commandArgs.get(0));
        try {
            Files.walk(root.toPath())
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
