package com.trustedshops.examples.javaDesignPatterns.utils.io;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Objects;

public final class IOFiles {
    private IOFiles() {
    }

    public static String getExtension(String path) {
        Objects.requireNonNull(path);
        return getExtension(FileSystems.getDefault().getPath(path));
    }

    public static String getExtension(Path nioPath) {
        Objects.requireNonNull(nioPath);
        String name = nioPath.getFileName().toString();
        int lastDot = name.lastIndexOf('.');
        if(lastDot > 0 && lastDot < name.length()) {
            return name.substring(lastDot + 1);
        }
        return "";
    }
}
