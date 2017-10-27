package com.trustedshops.examples.javaDesignPatterns.utils.io;

import java.nio.file.Path;

public final class IOFileFactory {
    private IOFileFactory() {
    }

    public static IOFile getFile(Path path) {
        return new IOFileImpl(path.getFileName().toString(), path.toString(),
                IOFiles.getExtension(path), path.toFile().length());
    }
}
