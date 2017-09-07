package com.trustedshops.examples.javaDesignPatterns.chain;

import java.nio.file.Path;

public interface IOFile {
    long getSize();
    String getPath();
    String getName();
    String getExtension();
}
