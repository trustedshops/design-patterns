package com.trustedshops.examples.javaDesignPatterns.utils.io;

public interface IOFile {
    long getSize();
    String getPath();
    String getName();
    String getExtension();
}
