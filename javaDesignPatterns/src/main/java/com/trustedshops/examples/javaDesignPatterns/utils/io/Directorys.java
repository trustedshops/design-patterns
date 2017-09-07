package com.trustedshops.examples.javaDesignPatterns.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public final class Directorys {
    private Directorys() {
    }

    public static void traverse(List<String> commandArgs, Consumer<Path> fileConsumer) {
        File root = new File(commandArgs.get(0));
        try {
            Files.walk(root.toPath())
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(fileConsumer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
