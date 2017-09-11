package com.trustedshops.examples.javaDesignPatterns.utils.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public final class Directories {
    private Directories() {
    }

    public static void traverse(String root, Consumer<Path> fileConsumer) {
        File rootFile = new File(root);
        try {
            Files.walk(rootFile.toPath())
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(fileConsumer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
