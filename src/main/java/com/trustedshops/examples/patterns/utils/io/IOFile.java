package com.trustedshops.examples.patterns.utils.io;

public interface IOFile {
    long getSize();
    String getPath();
    String getName();
    String getExtension();
}
