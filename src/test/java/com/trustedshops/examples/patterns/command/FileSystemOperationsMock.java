package com.trustedshops.examples.patterns.command;

import com.trustedshops.examples.patterns.command.io.FileSystemApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FileSystemOperationsMock implements FileSystemApi {
    private final List<String> files = new ArrayList<>();

    public FileSystemOperationsMock file(String path) {
        files.add(path);
        return this;
    }

    private void fileExists(String src) {
        if(!files.contains(src)) {
            throw new IllegalArgumentException("file not found: " + src);
        }
    }

    @Override
    public void copy(String src, String trg) {
        fileExists(src);
        file(trg);
    }

    @Override
    public void move(String src, String trg) {
        fileExists(src);
        file(trg);
        delete(src);
    }

    @Override
    public void delete(String path) {
        files.remove(path);
    }

    public Collection<String> getFiles() {
        ArrayList<String> result = new ArrayList<>(files);
        Collections.sort(result);
        return result;
    }

}
