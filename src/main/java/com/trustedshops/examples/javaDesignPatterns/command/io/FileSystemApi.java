package com.trustedshops.examples.javaDesignPatterns.command.io;

import java.nio.file.Path;

public interface FileSystemApi {
    void copy(String src, String trg);
    void move(String src, String trg);
    void delete(String path);
}
