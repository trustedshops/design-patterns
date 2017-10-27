package com.trustedshops.examples.patterns.command.io;

public interface FileSystemApi {
    void copy(String src, String trg);
    void move(String src, String trg);
    void delete(String path);
}
