package com.trustedshops.examples.javaDesignPatterns.utils.io;

public class IOFileImpl implements IOFile {
    private final String name;
    private final String path;
    private final String extension;
    private final long size;

    IOFileImpl(String name, String path, String extension, long size) {
        this.name = name;
        this.path = path;
        this.extension = extension;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getExtension() {
        return extension;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "IOFileImpl{" +
                "path='" + path + '\'' +
                '}';
    }
}
